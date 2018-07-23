/* Generated File */
package models.data.weapon

import models.animation.Animation
import models.template.weapon.WeaponTemplate

object Epic extends WeaponTemplate(
  key = "epic",
  name = "Epic",
  width = 44,
  height = 46,
  hitAudioClip = None,
  swingAudioClip = None,
  unuseAudioClip = None,
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(0), delay = 1.0, loop = false),
    Animation(id = "defaultCharged", frames = IndexedSeq(1, 2, 3, 4, 5, 6), delay = 0.1, loop = true),
    Animation(id = "wield", frames = IndexedSeq(0, 7, 8, 7), delay = 0.2, loop = false),
    Animation(id = "wieldCharged", frames = IndexedSeq(0, 7, 8, 7), delay = 0.2, loop = false)
  )
)
