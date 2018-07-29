package models.intro

import com.definitelyscala.phaserce.{Game, Group, Point}
import models.component.StaticSprite
import models.input.PointerAction
import util.Logging

class MainMenu(game: Game) {
  private[this] val group = new Group(game = game, name = s"main.menu")
  private[this] val size = 400.0
  private[this] var zoom = 1.0

  private[this] val background = StaticSprite(game, group, "intro.cityscape", 0, 0, "intro.cityscape")

  private[this] val logoGroup = new Group(game, group, "intro.logoGroup")
  private[this] val logo = StaticSprite(game, logoGroup, "intro.logo", 0, 0, "intro.logo")
  logo.sprite.anchor = util.PhaserUtils.centerPoint
  logo.sprite.scale = new Point(0.8, 0.8)

  game.world.add(group)
  resize(game.width.toInt, game.height.toInt)

  def resize(width: Int, height: Int) = {
    zoom = Math.min(width / size, height / size)
    group.scale = new Point(zoom, zoom)
    val newY = (background.sprite.height * zoom) - height
    group.position = new Point(0.0, -newY)
    logoGroup.position = new Point((width / 2.0) / zoom, background.sprite.height - (height / 1.6 / zoom))
  }

  def update(dt: Double) = {
  }

  def onPointer(act: PointerAction) = Logging.info(s"Main menu pointer event: [$act]")

  def menuActions(acts: Seq[String]) = Logging.info(s"Main menu actions: [${acts.mkString(", ")}]")
}
