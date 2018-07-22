/* Generated File */
package models.data.weapon

import models.template.weapon.WeaponTemplate

object Nunchucks extends WeaponTemplate(
  key = "nunchucks",
  name = "Nunchucks",
  width = 50,
  height = 40,
  hitAudioClip = Some("punch"),
  swingAudioClip = Some("sword_air"),
  unuseAudioClip = Some("sword_sheathed"),
  animations = Seq.empty
)
