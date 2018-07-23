/* Generated File */
package models.data.weapon

import models.animation.Animation
import models.template.weapon.WeaponTemplate

object Torch extends WeaponTemplate(
  key = "torch",
  name = "Torch",
  width = 48,
  height = 48,
  hitAudioClip = None,
  swingAudioClip = Some("fire_thrown"),
  unuseAudioClip = None,
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(0, 1, 2, 3, 4, 5), delay = 0.09, loop = true),
    Animation(id = "wield", frames = IndexedSeq(6, 7, 6, 7), delay = 0.11, loop = false)
  )
)
