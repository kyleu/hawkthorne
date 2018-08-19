package services.intro

import com.definitelyscala.phaserce.{Game, Sound}
import models.analytics.AnalyticsActionType
import models.input.{MenuAction, PointerAction}
import services.audio.MusicService
import services.input.InputService
import services.socket.AnalyticsService
import services.state.{GameState, LoadingState}

object IntroState {
  def load(phaser: Game, input: InputService, skipToMenu: Boolean = false, debug: Boolean = false) = {
    new LoadingState(next = new IntroState(phaser, input, skipToMenu, debug), phaser = phaser, assets = IntroAssets.assets)
  }
}

class IntroState(phaser: Game, inputService: InputService, skipToMenu: Boolean, debug: Boolean) extends GameState("introscan", phaser) {
  private[this] var elapsed = 0.0

  private[this] var introScan: Option[IntroScan] = None
  private[this] var flyIn: Option[FlyIn] = None
  private[this] var mainMenu: Option[MainMenu] = None
  private[this] var bgMusic: Option[Sound] = None

  override def create(game: Game) = {
    inputService.setPointerEventCallback(Some(pointerAct))
    inputService.menuHandler.setCallback(Some(acts => menuActs(acts)))

    if (skipToMenu) {
      mainMenu = Some(new MainMenu(game = phaser, input = inputService, debug = debug))
    } else {
      introScan = Some(new IntroScan(game = phaser, onComplete = () => switchToFlyIn(skipped = false)))
    }

    bgMusic = Some(MusicService.play("opening"))

    onResize(width = game.width.toInt, height = game.height.toInt)
    AnalyticsService.send(AnalyticsActionType.IntroStart, io.circe.Json.obj())
  }

  override def update(game: Game) = {
    val dt = game.time.physicsElapsed
    elapsed += dt
    inputService.update(dt)
    () match {
      case _ if introScan.isDefined => introScan.foreach(_.update(dt))
      case _ if flyIn.isDefined => flyIn.foreach(_.update(dt))
      case _ => mainMenu.foreach(_.update(dt))
    }
  }

  override def onResize(width: Int, height: Int) = {
    introScan.foreach(_.resize(width, height))
    flyIn.foreach(_.resize(width, height))
    mainMenu.foreach(_.resize(width, height))
  }

  override def shutdown(game: Game) = {
    bgMusic.foreach(_.stop())
    inputService.menuHandler.setCallback(None)
    inputService.setPointerEventCallback(None)
    super.shutdown(game)
  }

  private[this] def skip() = () match {
    case _ if introScan.isDefined => switchToFlyIn(skipped = true)
    case _ if flyIn.isDefined => switchToMenu()
    case _ => throw new IllegalStateException("Cannot skip...")
  }

  private[this] def pointerAct(pointerAction: PointerAction) = () match {
    case _ if introScan.isDefined => skip()
    case _ if flyIn.isDefined => skip()
    case _ => mainMenu.foreach(_.onPointer(pointerAction))
  }

  private[this] def menuActs(acts: Seq[MenuAction]) = () match {
    case _ if introScan.isDefined => skip()
    case _ if flyIn.isDefined => skip()
    case _ => mainMenu.foreach(_.menuActions(acts))
  }

  private[this] def switchToFlyIn(skipped: Boolean) = {
    if (skipped) {
      AnalyticsService.send(AnalyticsActionType.IntroSkip, io.circe.Json.obj())
    }
    introScan.foreach(_.destroy())
    introScan = None
    flyIn = Some(new FlyIn(phaser, () => switchToMenu()))
  }

  private[this] def switchToMenu() = {
    flyIn.foreach(_.destroy())
    flyIn = None
    mainMenu = Some(new MainMenu(game = phaser, input = inputService, debug = debug))
  }
}
