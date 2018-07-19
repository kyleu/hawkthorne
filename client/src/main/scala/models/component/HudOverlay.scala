package models.component

import com.definitelyscala.phaserce._
import models.asset.Asset
import models.component.BaseComponent.Resizable
import models.font.Font
import models.player.Player
import util.PhaserUtils

object HudOverlay {
  val assets = Seq(
    Asset.Image("hud.chevron", "images/hud/chevron.png"),
    Asset.Image("hud.energy", "images/hud/energy.png"),
    Asset.Image("hud.lens", "images/hud/lens.png")
  )
}

case class HudOverlay(game: Game, player: Player) extends BaseComponent with Resizable {
  val group = new Group(game, name = "hud.overlay")
  val scaleAmount = 2.0
  val scale = new Point(scaleAmount, scaleAmount)

  val chevron = new Sprite(game, 0, 0, "hud.chevron")
  chevron.name = "hud.chevron"
  chevron.scale = scale
  group.add(chevron)

  val headData = game.make.bitmapData(32, 32)
  headData.copyRect(player.spritesheet._1, new Rectangle(8, 2, 32, 32), 0, 0)

  val headshot = new Sprite(game, 14 * scaleAmount, 16 * scaleAmount, headData)
  headshot.name = "hud.headshot"
  headshot.scale = scale
  group.add(headshot)

  val lens = new Sprite(game, 0, 0, "hud.lens")
  lens.name = "hud.lens"
  lens.scale = scale
  group.add(lens)

  val font = Font.getFont("small", game)

  val nameText = font.renderToImage("hud.name", player.template.name, game, 58 * scaleAmount, 15 * scaleAmount, Some("#000"))
  nameText.scale = scale
  group.add(nameText)

  val pointsText = font.renderToImage("hud.currency", "0", game, 67 * scaleAmount, 41 * scaleAmount, Some("#000"))
  pointsText.scale = scale
  group.add(pointsText)

  resize(game.width, game.height)
  game.stage.add(group)

  override def resize(width: Double, height: Double) = {
    val groupScale = 1.0 // Math.max(1.0, ((width + height) / 1200.0 / scaleAmount)).toInt.toDouble
    group.scale = new Point(groupScale, groupScale)
  }
}

