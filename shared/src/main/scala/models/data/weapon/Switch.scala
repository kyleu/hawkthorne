/* Generated File */
package models.data.weapon

import models.template.weapon.WeaponTemplate

object Switch extends WeaponTemplate(
  key = "switch",
  name = "Switch",
  width = 50,
  height = 40,
  hitAudioClip = Some("punch"),
  swingAudioClip = Some("sword_air"),
  unuseAudioClip = Some("sword_sheathed"),
  animations = Seq.empty
)
