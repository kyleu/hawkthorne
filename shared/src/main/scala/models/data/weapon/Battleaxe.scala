/* Generated File */
package models.data.weapon

import models.animation.Animation
import models.template.weapon.WeaponTemplate

object Battleaxe extends WeaponTemplate(
  key = "battleaxe",
  name = "Battleaxe",
  width = 50,
  height = 35,
  hitAudioClip = Some("mace_hit"),
  swingAudioClip = None,
  unuseAudioClip = None,
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(0), delay = 1.0, loop = false),
    Animation(id = "wield", frames = IndexedSeq(1, 2), delay = 0.22, loop = false)
  )
)
