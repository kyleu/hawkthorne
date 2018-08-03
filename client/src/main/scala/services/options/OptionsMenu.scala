package services.options

import com.definitelyscala.phaserce.{Game, Group, Point}
import models.component.Menu

class OptionsMenu(game: Game) {
  private[this] val menu = Menu(game = game, name = "options.menu", fontKey = "small", backgroundKey = "options.menu.bg", width = 272, height = 176)
  game.stage.add(menu.group)
  private[this] val (mw, mh) = (menu.width * menu.group.scale.x, menu.height * menu.group.scale.y)

  def update(dt: Double) = {
  }

  def resize(width: Int, height: Int) = {
    val zoom = Math.min(width / menu.background.width, height / menu.background.height)
    menu.group.scale = new Point(zoom, zoom)
    menu.x = (width - menu.background.width) / 2
    menu.y = (height - menu.background.height) / 2
  }
}
