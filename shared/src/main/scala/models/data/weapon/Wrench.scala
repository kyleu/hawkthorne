/* Generated File */
package models.data.weapon

import models.template.weapon.WeaponTemplate

object Wrench extends WeaponTemplate(
  key = "wrench",
  name = "Wrench",
  width = 30,
  height = 40,
  hitAudioClip = Some("anvil"),
  swingAudioClip = None,
  unuseAudioClip = None,
  animations = Seq.empty
)
