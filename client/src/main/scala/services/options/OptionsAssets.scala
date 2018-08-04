package services.options

import models.asset.Asset
import models.font.Font
import services.audio.SoundEffectService

object OptionsAssets {
  val assets = Font.assets ++ SoundEffectService.menuAssets ++ Seq(
    Asset.music("daybreak"),
    Asset.Image("options.checkbox.true", "images/menu/checkbox_checked.png"),
    Asset.Image("options.checkbox.false", "images/menu/checkbox_unchecked.png"),
    Asset.Image("options.menu.bg", "images/menu/pause.png"),
    Asset.Image(s"options.menu.arrow", s"images/menu/arrow.png"),
    Asset.Image(s"options.meter.bg", s"images/menu/range.png"),
    Asset.Image(s"options.meter.arrow", s"images/menu/small_arrow_up.png")
  )
}
