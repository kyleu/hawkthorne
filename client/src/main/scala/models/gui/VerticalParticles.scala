package models.gui

import com.definitelyscala.phaserce.{BitmapData, Game, Group, Image}
import util.NullUtils

import scala.util.Random

class VerticalParticles(game: Game) {
  val group = new Group(game, NullUtils.inst, "vertical.particles", addToStage = true)

  private[this] val all = IndexedSeq(1 -> 1, 1 -> 2, 1 -> 3, 2 -> 2).zipWithIndex.map {
    case ((w, h), idx) => new BitmapData(game, s"small-particle-$idx", w.toDouble, h.toDouble)
  }
  all.foreach(_.fill(255, 255, 255))

  private[this] val images = (0 until 256).map { idx =>
    val x = Random.nextInt(game.width.toInt).toDouble
    val y = Random.nextInt(game.height.toInt).toDouble
    val ratio = 1.0 - Math.cos(Math.abs(x - game.width / 2) * 2 / game.width) * 0.6
    val i = new Image(game, x, y, all(Random.nextInt(all.length)))
    i.data = 300 * (ratio + math.random() / 4)
    i.name = s"particle.$idx"
    group.add(i)
    i
  }

  def update(dt: Double) = {
    images.foreach { i =>
      i.y -= (i.data.asInstanceOf[Double] * dt)
      if (i.y < -10) {
        i.x = Random.nextDouble() * game.width
        i.y = game.height + 10
      }
    }
  }
}
