/* Generated File */
package models.data.weapon

import models.template.weapon.WeaponTemplate

object Battleaxe extends WeaponTemplate(
  key = "battleaxe",
  name = "Battleaxe",
  width = 50,
  height = 35,
  hitAudioClip = Some("mace_hit"),
  swingAudioClip = None,
  unuseAudioClip = None,
  animations = Seq.empty
)
