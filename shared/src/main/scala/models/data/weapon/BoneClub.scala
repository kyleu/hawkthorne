/* Generated File */
package models.data.weapon

import models.template.weapon.WeaponTemplate

object BoneClub extends WeaponTemplate(
  key = "boneclub",
  name = "BoneClub",
  width = 50,
  height = 40,
  hitAudioClip = Some("punch"),
  swingAudioClip = Some("sword_air"),
  unuseAudioClip = Some("sword_sheathed"),
  animations = Seq.empty
)
