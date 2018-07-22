/* Generated File */
package models.data.weapon

import models.template.weapon.WeaponTemplate

object Scythe extends WeaponTemplate(
  key = "scythe",
  name = "Scythe",
  width = 30,
  height = 61,
  hitAudioClip = Some("sword_hit"),
  swingAudioClip = Some("sword_air"),
  unuseAudioClip = None,
  animations = Seq.empty
)
