package services.map

import com.definitelyscala.phaserce.{Game, Group, Point, Sprite}
import models.font.Font

class OverworldTitleboard(game: Game) {
  private[this] val group = new Group(game = game, name = "")
  game.stage.add(group)

  private[this] val bg = new Sprite(game, 0, 0, "overworld.titleboard")
  bg.name = "overworld.titleboard.bg"
  group.add(bg)

  private[this] def font = Font.getFont("big", game)
  private[this] var titleText = textFor("TEST")
  group.add(titleText)

  def resize(zoom: Double) = {
    group.scale = new Point(zoom, zoom)
    group.position = new Point((game.width - (bg.width * zoom)) / 2, game.height - ((bg.height * zoom) * 1.5))
  }

  def setText(s: String) = {
    group.remove(titleText)
    titleText.destroy()
    titleText = textFor(s)
    group.add(titleText)
  }

  private[this] def textFor(s: String) = {
    val i = font.renderToImage(name = "overworld.titleboard.text", s = s, game = game)
    i.position = new Point((bg.width - i.width) / 2, (bg.height - i.height) / 2)
    i
  }
}
