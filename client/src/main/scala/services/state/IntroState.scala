package services.state

import com.definitelyscala.phaserce.{Game, Sound}
import models.input.{MenuAction, PointerAction}
import models.intro.{FlyIn, IntroAssets, IntroScan, MainMenu}
import services.input.InputService

object IntroState {
  def load(phaser: Game, skipToMenu: Boolean = false, debug: Boolean = false) = {
    new LoadingState(next = new IntroState(phaser, skipToMenu, debug), phaser = phaser, assets = IntroAssets.assets)
  }
}

class IntroState(phaser: Game, skipToMenu: Boolean, debug: Boolean) extends GameState("introscan", phaser) {
  private[this] var elapsed = 0.0

  private[this] lazy val inputService = new InputService(game)

  private[this] var introScan: Option[IntroScan] = None
  private[this] var flyIn: Option[FlyIn] = None
  private[this] var mainMenu: Option[MainMenu] = None
  private[this] var music: Option[Sound] = None

  override def create(game: Game) = {
    inputService.setPointerEventCallback(Some(pointerAct))
    inputService.menuHandler.setCallback(Some(acts => menuActs(acts)))

    if (skipToMenu) {
      mainMenu = Some(new MainMenu(game = phaser, debug = debug))
    } else {
      introScan = Some(new IntroScan(game = phaser, onComplete = () => switchToFlyIn()))
    }

    music = Some(game.add.audio(key = "music.opening"))
    music.foreach(_.play())

    onResize(width = game.width.toInt, height = game.height.toInt)
  }

  override def update(game: Game) = {
    val dt = game.time.physicsElapsed
    elapsed += dt

    inputService.update(dt)

    introScan match {
      case Some(is) => is.update(dt)
      case None => flyIn match {
        case Some(fi) => fi.update(dt)
        case None => mainMenu.foreach(_.update(dt))
      }
    }
  }

  override def onResize(width: Int, height: Int) = {
    introScan.foreach(_.resize(width, height))
    flyIn.foreach(_.resize(width, height))
    mainMenu.foreach(_.resize(width, height))
  }

  override def shutdown(game: Game) = {
    music.foreach(_.stop())
    super.shutdown(game)
  }

  private[this] def skip() = introScan match {
    case Some(_) => switchToFlyIn()
    case None => flyIn match {
      case Some(_) => switchToMenu()
      case None => throw new IllegalStateException("Cannot skip...")
    }
  }

  private[this] def pointerAct(pointerAction: PointerAction) = introScan match {
    case Some(_) => skip()
    case None => flyIn match {
      case Some(_) => skip()
      case None => mainMenu.foreach(_.onPointer(pointerAction))
    }
  }

  private[this] def menuActs(acts: Seq[MenuAction]) = introScan match {
    case Some(_) => skip()
    case None => flyIn match {
      case Some(_) => skip()
      case None => mainMenu.foreach(_.menuActions(acts))
    }
  }

  private[this] def switchToFlyIn() = {
    introScan.foreach(_.destroy())
    introScan = None
    flyIn = Some(new FlyIn(phaser, () => switchToMenu()))
  }

  private[this] def switchToMenu() = {
    flyIn.foreach(_.destroy())
    flyIn = None
    mainMenu = Some(new MainMenu(phaser, debug))
  }
}
