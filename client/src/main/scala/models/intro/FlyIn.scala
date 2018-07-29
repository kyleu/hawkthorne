package models.intro

import com.definitelyscala.phaserce.{Game, Group, Math, Point}
import models.component.StaticSprite

class FlyIn(game: Game, onComplete: () => Unit) {
  private[this] val dimensions = 640 -> 480

  private[this] val group = new Group(game = game, name = s"intro.fly.in")

  private[this] val background = StaticSprite(game, group, "intro.cityscape", 0, 0, "intro.cityscape")

  game.world.add(group)
  resize(game.width.toInt, game.height.toInt)

  def resize(width: Int, height: Int) = {
    val wRatio = width.toDouble / dimensions._1
    val hRatio = height.toDouble / dimensions._2
    val scale = Math.min(wRatio, hRatio)
    val x = (width - (dimensions._1 * scale)) / 2
    val y = (height - (dimensions._2 * scale)) / 2
    util.Logging.info(s"width: $width, height: $height, wRatio: $wRatio, hRatio: $hRatio, scale: $scale, x: $x, y: $y")
    group.position.set(Math.max(x, 0), Math.max(y, 0))
    group.scale = new Point(scale, scale)
  }

  def update(dt: Double, elapsed: Double) = {
  }

  def destroy() = {
    game.world.remove(group)
    group.alive = false
    group.visible = false
  }
}
