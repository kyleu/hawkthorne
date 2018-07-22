/* Generated File */
package models.data.weapon

import models.template.weapon.WeaponTemplate

object CrimsonSword extends WeaponTemplate(
  key = "crimson_sword",
  name = "CrimsonSword",
  width = 50,
  height = 40,
  hitAudioClip = Some("sword_hit"),
  swingAudioClip = Some("sword_air"),
  unuseAudioClip = Some("sword_sheathed"),
  animations = Seq.empty
)
