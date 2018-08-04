package services.overworld

import models.asset.Asset
import models.font.Font

object OverworldMapAssets {
  val music = "overworld"
  val bgColor = "#85B9FA"

  private[this] val keys = Seq(
    "world_01", "world_02", "world_03", "world_04", "world_05", "world_06", "world_07", "world_08",
    "world_overlay_01", "world_overlay_02", "world_overlay_05", "world_overlay_06", "titleboard", "flag", "free_ride_ferry"
  )

  private[this] val baseAssets = Font.assets ++ keys.map(k => Asset.Image(s"overworld.$k", s"images/overworld/$k.png")) ++ Seq(
    Asset.music("overworld"),
    Asset.Spritesheet("overworld.sparkle", "images/overworld/gay_sparkle.png", 24, 24),
    Asset.Spritesheet("overworld.water", "images/overworld/world_water.png", 36, 36),
    Asset.Spritesheet("overworld.cloud", "images/overworld/cloud_puff.png", 100, 67)
  )

  def assets(key: String) = baseAssets :+ {
    Asset.Spritesheet(s"overworld.player.$key", s"images/characters/$key/overworld.png", 36, 36)
  }
}
