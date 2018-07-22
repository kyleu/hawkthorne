/* Generated File */
package models.data.weapon

import models.template.weapon.WeaponTemplate

object Longsword extends WeaponTemplate(
  key = "longsword",
  name = "Longsword",
  width = 30,
  height = 30,
  hitAudioClip = Some("sword_hit"),
  swingAudioClip = Some("sword_air"),
  unuseAudioClip = None,
  animations = Seq.empty
)
