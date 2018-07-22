/* Generated File */
package models.data.weapon

import models.template.weapon.WeaponTemplate

object Torch extends WeaponTemplate(
  key = "torch",
  name = "Torch",
  width = 48,
  height = 48,
  hitAudioClip = None,
  swingAudioClip = Some("fire_thrown"),
  unuseAudioClip = None,
  animations = Seq.empty
)
