package models.gui

import com.definitelyscala.phaserce._
import models.asset.Asset
import models.player.Player

object HudOverlay {
  val assets = Seq(
    Asset.Image("hud.chevron", "images/hud/chevron.png"),
    Asset.Image("hud.energy", "images/hud/energy.png"),
    Asset.Image("hud.lens", "images/hud/lens.png")
  )
}

final case class HudOverlay(game: Game, players: IndexedSeq[Player]) {
  val group = new Group(game, name = "hud.overlay")
  game.stage.add(group)

  val playerHuds = players.map(p => PlayerHud(game, p, group))

  def setEnergy(idx: Int, amt: Int, max: Int) = playerHuds(idx).setEnergy(amt, max)
  def debugString() = playerHuds.map(_.debugString()).mkString("\n")

  def resize(width: Int, height: Int, zoom: Double) = {
    val newZoom = Math.max(1.0, Math.min(6.0, zoom.floor))
    group.scale.set(newZoom, newZoom)
  }

  def destroy() = group.destroy()
}

