/* Generated File */
package models.data.weapon

import models.template.weapon.WeaponTemplate

object Dagger extends WeaponTemplate(
  key = "dagger",
  name = "Dagger",
  width = 28,
  height = 31,
  hitAudioClip = Some("sword_hit"),
  swingAudioClip = Some("sword_air"),
  unuseAudioClip = Some("sword_sheathed"),
  animations = Seq.empty
)
