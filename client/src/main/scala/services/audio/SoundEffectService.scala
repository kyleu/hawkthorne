package services.audio

import models.asset.Asset

object SoundEffectService extends AudioService("sfx") {
  val menuAssets = Seq("click", "confirm").map(Asset.sfx)

  val gameplayAssets = Seq(
    "beep", "damage", "dbl_beep", "death", "jump", "locked", "menu_close", "menu_expand", "pickup", "punch", "respawn", "reveal", "pickup", "unlocked"
  ).map(Asset.sfx)
}
