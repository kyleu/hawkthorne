/* Generated File */
package models.data.weapon

import models.template.weapon.WeaponTemplate

object Axe extends WeaponTemplate(
  key = "axe",
  name = "Axe",
  width = 23,
  height = 23,
  hitAudioClip = Some("mace_hit"),
  swingAudioClip = None,
  unuseAudioClip = None,
  animations = Seq.empty
)
