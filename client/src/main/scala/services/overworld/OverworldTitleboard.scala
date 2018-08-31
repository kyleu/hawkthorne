package services.overworld

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
  group.add(titleText.group)

  def resize(zoom: Double) = {
    group.scale.set(zoom, zoom)
    group.position = new Point((game.width - (bg.width * zoom)) / 2, game.height - ((bg.height * zoom) * 1.5))
  }

  def setText(s: String) = {
    group.remove(titleText.group)
    titleText.group.destroy()
    titleText = textFor(s)
    group.add(titleText.group)
  }

  def destroy() = {
    game.stage.removeChild(group)
    group.destroy()
  }

  private[this] def textFor(s: String) = {
    val i = font.renderSimple(name = "overworld.titleboard.text", text = s, game = game)
    i.group.position = new Point((bg.width - i.group.width) / 2, (bg.height - i.group.height) / 2)
    i
  }
}
