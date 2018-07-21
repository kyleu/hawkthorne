package models.component

import com.definitelyscala.phaserce._
import models.asset.Asset
import models.font.Font
import models.player.Player

object HudOverlay {
  val assets = Seq(
    Asset.Image("hud.chevron", "images/hud/chevron.png"),
    Asset.Image("hud.energy", "images/hud/energy.png"),
    Asset.Image("hud.lens", "images/hud/lens.png")
  )
}

case class HudOverlay(override val game: Game, player: Player, override val x: Int = 0, override val y: Int = 0) extends BaseComponent {
  override val name = "hud"

  val group = new Group(game, name = "hud.overlay")
  group.x = x.toDouble
  group.y = y.toDouble

  val chevron = new Sprite(game, 0, 0, "hud.chevron")
  chevron.name = "hud.chevron"
  group.add(chevron)

  val headData = game.make.bitmapData(32, 32)
  headData.copyRect(player.spritesheet._1, new Rectangle(8, 2, 32, 32), 0, 0)

  val headshot = new Sprite(game, 14, 16, headData)
  headshot.name = "hud.headshot"
  group.add(headshot)

  val lens = new Sprite(game, 0, 0, "hud.lens")
  lens.name = "hud.lens"
  group.add(lens)

  val font = Font.getFont("small", game)

  val nameText = font.renderToImage("hud.name", player.template.name, game, 58, 15, Some("#000"))
  group.add(nameText)

  val pointsText = font.renderToImage("hud.currency", "0", game, 67, 41, Some("#000"))
  group.add(pointsText)

  game.stage.add(group)
}

