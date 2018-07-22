package services.audio

import models.asset.Asset

object SoundEffectService {

  val menuAssets = Seq(
    Seq("click", "confirm").map(Asset.sfx)
  ).flatten

  val gameplayAssets = Seq(
    Seq("beep", "damage", "dbl_beep", "death", "jump", "locked", "pickup", "punch", "respawn", "reveal", "pickup", "unlocked").map(Asset.sfx)
  ).flatten
}
