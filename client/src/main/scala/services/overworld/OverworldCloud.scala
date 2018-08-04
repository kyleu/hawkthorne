package services.overworld

import com.definitelyscala.phaserce.{Group, Sprite}
import util.PhaserUtils

import scala.util.Random

case class OverworldCloud(idx: Int, group: Group, dimensions: (Double, Double)) {
  private[this] val size = Random.nextInt(3)
  private[this] val speed = (Random.nextInt(15) + 5) * (if (Random.nextBoolean) { 1 } else { -1 })
  private[this] var opacity = 0.8

  val sprite = {
    val x = Random.nextDouble() * dimensions._1
    val y = Random.nextDouble() * dimensions._2
    new Sprite(game = group.game, x = x, y = y, key = "overworld.cloud", frame = size.toDouble)
  }
  sprite.name = s"overworld.cloud.$idx"
  sprite.scale = PhaserUtils.doublePoint
  sprite.alpha = opacity
  group.add(sprite)

  def reset() = {
    sprite.x = Random.nextDouble() * dimensions._1
    sprite.y = Random.nextDouble() * dimensions._2
    opacity = 0
  }

  def update(dt: Double) = {
    sprite.x = sprite.x + (dt * speed)
    if (opacity < 0.8) {
      opacity = Math.min(0.8, opacity + dt)
    }
    def oobX = sprite.x < -sprite.width || sprite.x > (dimensions._1 + sprite.width)
    def oobY = sprite.y < -sprite.height || sprite.y > (dimensions._2 + sprite.height)
    if (oobX || oobY) {
      reset()
    }
  }
}
