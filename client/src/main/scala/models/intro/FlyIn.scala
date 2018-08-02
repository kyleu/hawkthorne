package models.intro

import com.definitelyscala.phaserce.{Game, Group, Math, Point}
import models.component.StaticSprite
import util.PhaserUtils

class FlyIn(game: Game, onComplete: () => Unit) {
  private[this] val dimensions = 640 -> 480

  private[this] val group = new Group(game = game, name = s"intro.fly.in")

  private[this] val background = StaticSprite(game, group, "intro.cityscape", "intro.cityscape")

  game.world.add(group)
  resize(game.width.toInt, game.height.toInt)

  def resize(width: Int, height: Int) = PhaserUtils.simpleResize(group, width, height, dimensions)

  def update(dt: Double) = {
    onComplete() // TODO
  }

  def destroy() = {
    game.world.remove(group)
    group.destroy(destroyChildren = true)
  }
}
