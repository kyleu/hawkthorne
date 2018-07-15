package models.component

import com.definitelyscala.phaserce._
import models.asset.Asset
import models.component.BaseComponent.Resizable
import models.player.Player

object HudOverlay {
  val assets = Seq(
    Asset.Image("hud.chevron", "images/hud/chevron.png"),
    Asset.Image("hud.energy", "images/hud/energy.png"),
    Asset.Image("hud.lens", "images/hud/lens.png")
  )
}

case class HudOverlay(game: Game, player: Player) extends BaseComponent with Resizable {
  val group = new Group(game, name = "hud.overlay")

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

  resize(game.width, game.height)
  game.stage.add(group)

  override def update(deltaMs: Double) = {

  }

  override def resize(width: Double, height: Double) = {
    val groupScale = (width + height) / 1600.0
    group.scale = new Point(groupScale, groupScale)
  }
}

