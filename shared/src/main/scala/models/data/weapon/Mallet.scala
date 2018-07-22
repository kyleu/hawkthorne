/* Generated File */
package models.data.weapon

import models.template.weapon.WeaponTemplate

object Mallet extends WeaponTemplate(
  key = "mallet",
  name = "Mallet",
  width = 30,
  height = 40,
  hitAudioClip = Some("mallet_hit"),
  swingAudioClip = None,
  unuseAudioClip = None,
  animations = Seq.empty
)
