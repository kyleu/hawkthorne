package services.state

import com.definitelyscala.phaserce._
import models.input.PointerAction
import models.intro.{FlyIn, IntroAssets, IntroScan, MainMenu}
import models.phaser.PhaserGame
import services.input.InputService
import util.Logging

object IntroState {
  def load(phaser: PhaserGame) = {
    new LoadingState(next = new IntroState(phaser), phaser = phaser, assets = IntroAssets.assets)
  }
}

class IntroState(phaser: PhaserGame) extends GameState("introscan", phaser) {
  private[this] var elapsed = 0.0

  private[this] lazy val inputService = new InputService(game)

  private[this] var introScan: Option[IntroScan] = None
  private[this] var flyIn: Option[FlyIn] = None
  private[this] var mainMenu: Option[MainMenu] = None

  override def create(game: Game) = {
    inputService.setPointerEventCallback(Some(pointerAct))
    inputService.menuHandler.setCallback(Some(acts => menuActs(acts)))

    introScan = Some(new IntroScan(phaser, () => switchToFlyIn()))

    // game.add.audio("music.opening").play(loop = false)

    onResize(game.width.toInt, game.height.toInt)
  }

  override def update(game: Game) = {
    val dt = game.time.physicsElapsed
    elapsed += dt

    inputService.update(dt)

    introScan match {
      case Some(is) => is.update(dt)
      case None => flyIn match {
        case Some(fi) => fi.update(dt)
        case None => // throw new IllegalStateException("Intro complete...")
      }
    }
  }

  override def onResize(width: Int, height: Int) = {
    introScan.foreach(_.resize(width, height))
    flyIn.foreach(_.resize(width, height))
    mainMenu.foreach(_.resize(width, height))
  }

  private[this] def skip() = introScan match {
    case Some(is) => switchToFlyIn()
    case None => flyIn match {
      case Some(fi) => switchToMenu()
      case None => throw new IllegalStateException("Cannot skip...")
    }
  }

  private[this] def pointerAct(pointerAction: PointerAction) = introScan match {
    case Some(is) => skip()
    case None => flyIn match {
      case Some(fi) => skip()
      case None => mainMenu.foreach(_.onPointer(pointerAction))
    }
  }

  private[this] def menuActs(acts: Seq[String]) = introScan match {
    case Some(is) => skip()
    case None => flyIn match {
      case Some(fi) => skip()
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
    mainMenu = Some(new MainMenu(phaser))
  }
}
