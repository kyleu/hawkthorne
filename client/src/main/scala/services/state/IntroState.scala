package services.state

import com.definitelyscala.phaserce._
import models.intro.{FlyIn, IntroAssets, IntroScan}
import models.phaser.PhaserGame
import services.input.InputService
import util.Logging

object IntroState {
  def load(phaser: PhaserGame) = {
    new LoadingState(next = new IntroState(phaser), phaser = phaser, assets = IntroAssets.assets)
  }
}

class IntroState(phaser: PhaserGame) extends GameState("introscan", phaser) {
  private[this] var elapsed: Double = 0.0

  private[this] lazy val inputService = new InputService(game)

  private[this] var introScan: Option[IntroScan] = None
  private[this] var flyIn: Option[FlyIn] = None

  override def create(game: Game) = {
    inputService.menuHandler.setCallback(Some(acts => Logging.info(s"Input: [${acts.mkString(", ")}]")))
    introScan = Some(new IntroScan(phaser, () => switchToFlyIn()))
    // game.add.audio("music.opening").play(loop = false)
    onResize(game.width.toInt, game.height.toInt)
  }

  override def update(game: Game) = {
    val dt = game.time.physicsElapsed
    elapsed += dt

    inputService.update(dt)

    introScan match {
      case Some(is) => is.update(dt, elapsed)
      case None => flyIn match {
        case Some(fi) => fi.update(dt, elapsed)
        case None => throw new IllegalStateException("Intro complete...")
      }
    }
  }

  override def onResize(width: Int, height: Int) = {
    introScan.foreach(_.resize(width, height))
    flyIn.foreach(_.resize(width, height))
  }

  private[this] def switchToFlyIn() = {
    introScan.foreach(_.destroy())
    introScan = None
    flyIn = Some(new FlyIn(phaser, () => switchToMenu()))
  }

  private[this] def switchToMenu() = {
    flyIn.foreach(_.destroy())
    flyIn = None
  }
}
