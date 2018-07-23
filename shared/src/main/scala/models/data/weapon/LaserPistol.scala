/* Generated File */
package models.data.weapon

import models.animation.Animation
import models.template.weapon.WeaponTemplate

object LaserPistol extends WeaponTemplate(
  key = "laser_pistol",
  name = "LaserPistol",
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
