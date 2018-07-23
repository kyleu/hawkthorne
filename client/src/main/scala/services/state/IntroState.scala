package services.state

import com.definitelyscala.phaserce._
import models.intro.{IntroAssets, IntroScan}

object IntroState {
  def load(phaser: Game) = {
    new LoadingState(next = new IntroState(phaser), phaser = phaser, assets = IntroAssets.assets)
  }
}

class IntroState(phaser: Game) extends GameState("introscan", phaser) {
  private[this] var elapsed: Double = 0.0

  private[this] var introScan: Option[IntroScan] = None

  override def create(game: Game) = {
    introScan = Some(new IntroScan(phaser))
    onResize(game.width.toInt, game.height.toInt)
  }

  override def update(game: Game) = {
    val dt = game.time.physicsElapsed
    elapsed += dt

    introScan.foreach(_.update(dt, elapsed))
  }

  override def onResize(width: Int, height: Int) = {
    val is = introScan.getOrElse(throw new IllegalStateException("Not initialized"))
    val wRatio = width.toDouble / is.dimensions._1
    val hRatio = height.toDouble / is.dimensions._2
    val scale = Math.min(wRatio, hRatio)
    val x = (width - (is.dimensions._1 * scale)) / 2
    val y = (height - (is.dimensions._2 * scale)) / 2
    util.Logging.info(s"width: $width, height: $height, wRatio: $wRatio, hRatio: $hRatio, scale: $scale, x: $x, y: $y")
    is.group.position.set(Math.max(x, 0), Math.max(y, 0))
    is.group.scale = new Point(scale, scale)
  }
}
