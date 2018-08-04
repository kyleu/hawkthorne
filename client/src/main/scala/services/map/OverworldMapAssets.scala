package services.map

import models.asset.Asset

object OverworldMapAssets {
  val music = "overworld"
  val bgColor = "#85B9FA"

  private[this] val keys = Seq(
    "world_01", "world_02", "world_03", "world_04", "world_05", "world_06", "world_07", "world_08",
    "world_overlay_01", "world_overlay_02", "world_overlay_05", "world_overlay_06",
    "titleboard", "flag", "free_ride_ferry", "world_water", "cloud_puff", "gay_sparkle"
  )

  val assets = Asset.music("overworld") +: keys.map(k => Asset.Image(s"overworld.$k", s"images/overworld/$k.png"))
}
