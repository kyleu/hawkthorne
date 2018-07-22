package services.state

import com.definitelyscala.phaserce._
import models.intro.{IntroAssets, IntroScan}

object IntroState {
  def load(phaser: Game) = {
    new LoadingState(next = new IntroState(phaser), phaser = phaser, assets = IntroAssets.assets)
  }

  val rtime = 10.0
  val ctime = rtime / 7
  val ftime = ctime / 3
  val stime = ctime - ftime
}

class IntroState(game: Game) extends GameState("introscan", game) {
  private[this] var elapsed: Double = 0.0

  private[this] lazy val introScan = new IntroScan(game)

  override def create(game: Game) = {
    game.world.add(introScan.group)
    resize(game.width, game.height)
  }

  override def update(game: Game) = {
    val dt = game.time.physicsElapsed
    elapsed += dt

    introScan.update(dt, elapsed)
  }

  override def resize(width: Double, height: Double) = {
    val wRatio = width / introScan.dimensions._1
    val hRatio = height / introScan.dimensions._2
    val scale = Math.min(wRatio, hRatio)
    util.Logging.info(s"wRatio: $wRatio, hRatio: $hRatio, scale: $scale")
    introScan.group.scale = new Point(scale, scale)
  }
}
