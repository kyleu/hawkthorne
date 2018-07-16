package models.component

import com.definitelyscala.phaserce._
import models.asset.Asset
import models.component.BaseComponent.Resizable
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
  val scaleAmount = 4.0
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

  val nameText = new Text(game, 58 * scaleAmount, 14 * scaleAmount, player.template.name, PhaserUtils.textStyle(fontSize = 36, fill = "000"))
  group.add(nameText)

  resize(game.width, game.height)
  game.stage.add(group)

  override def update(deltaMs: Double) = {

  }

  override def resize(width: Double, height: Double) = {
    val groupScale = (width + height) / 1200.0 / scaleAmount
    group.scale = new Point(groupScale, groupScale)
  }
}

