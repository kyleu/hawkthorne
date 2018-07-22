package services.audio

import models.asset.Asset

object SoundEffectService {
  private[this] def sfx(k: String) = Asset.Audio(s"sfx.$k", s"audio/sfx/$k.ogg")

  val menuAssets = Seq(
    Seq("click", "confirm").map(sfx)
  ).flatten

  val gameplayAssets = Seq(
    Seq("beep", "damage", "dbl_beep", "death", "jump", "locked", "pickup", "punch", "respawn", "reveal", "pickup", "unlocked").map(sfx)
  ).flatten
}
