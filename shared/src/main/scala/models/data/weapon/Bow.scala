/* Generated File */
package models.data.weapon

import models.animation.Animation
import models.template.weapon.WeaponTemplate

object Bow extends WeaponTemplate(
  key = "bow",
  name = "Bow",
  width = 69,
  height = 27,
  hitAudioClip = None,
  swingAudioClip = None,
  unuseAudioClip = None,
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(0), delay = 1.0, loop = false),
    Animation(id = "wield", frames = IndexedSeq(0, 0, 1, 2), delay = 0.12, loop = false)
  )
)
