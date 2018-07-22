/* Generated File */
package models.data.weapon

import models.template.weapon.WeaponTemplate

object Mace extends WeaponTemplate(
  key = "mace",
  name = "Mace",
  width = 50,
  height = 35,
  hitAudioClip = Some("mace_hit"),
  swingAudioClip = None,
  unuseAudioClip = None,
  animations = Seq.empty
)
