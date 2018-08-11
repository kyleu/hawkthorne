package models.gui

import com.definitelyscala.phaserce._
import models.asset.Asset
import models.data.character.{Annie, Britta, Shirley, Troy}
import models.font.Font
import models.player.Player

object HudOverlay {
  val assets = Seq(
    Asset.Image("hud.chevron", "images/hud/chevron.png"),
    Asset.Image("hud.energy", "images/hud/energy.png"),
    Asset.Image("hud.lens", "images/hud/lens.png")
  )
}

final case class HudOverlay(game: Game, player: Player) {
  val group = new Group(game, name = "hud.overlay")

  private[this] val chevron = new Sprite(game, 0, 0, "hud.chevron")
  chevron.name = "hud.chevron"
  group.add(chevron)

  private[this] val headData = game.make.bitmapData(32, 32)
  private[this] val headshotY = player.template match {
    case Annie => 12.0
    case Britta => 8.0
    case Shirley => 10.0
    case Troy => 8.0
    case _ => 2.0
  }
  headData.copyRect(player.spritesheet._1, new Rectangle(8, headshotY + 48, 32, 32), 0, 0)

  private[this] val headshot = new Sprite(game, 14, 16, headData)
  headshot.name = "hud.headshot"
  group.add(headshot)

  private[this] val lens = new Sprite(game, 0, 0, "hud.lens")
  lens.name = "hud.lens"
  group.add(lens)

  private[this] val font = Font.getFont("small", game)

  private[this] val nameText = font.render(name = "hud.name", text = player.template.name, game = game, x = 58, y = 15, color = Some(0x000000))
  group.add(nameText.group)

  private[this] val pointsText = font.render("hud.currency", "0", game, 67, 41, Some(0x000000))
  group.add(pointsText.group)

  game.stage.add(group)

  def resize(width: Int, height: Int, zoom: Double) = {
    val newZoom = Math.max(1.0, Math.min(6.0, zoom.floor))
    group.scale.set(newZoom, newZoom)
  }

  def debugString() = pointsText.text
}

