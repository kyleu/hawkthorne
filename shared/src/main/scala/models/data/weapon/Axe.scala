/* Generated File */
package models.data.weapon

import models.animation.Animation
import models.template.weapon.WeaponTemplate

object Axe extends WeaponTemplate(
  key = "axe",
  name = "Axe",
  width = 23,
  height = 23,
  hitAudioClip = Some("mace_hit"),
  swingAudioClip = None,
  unuseAudioClip = None,
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(0), delay = 1.0, loop = false),
    Animation(id = "wield", frames = IndexedSeq(0, 1, 2), delay = 0.09, loop = false)
  )
)
