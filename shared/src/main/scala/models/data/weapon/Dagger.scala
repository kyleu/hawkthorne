/* Generated File */
package models.data.weapon

import models.animation.Animation
import models.template.weapon.WeaponTemplate

object Dagger extends WeaponTemplate(
  key = "dagger",
  name = "Dagger",
  width = 28,
  height = 31,
  hitAudioClip = Some("sword_hit"),
  swingAudioClip = Some("sword_air"),
  unuseAudioClip = Some("sword_sheathed"),
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(0), delay = 1.0, loop = false),
    Animation(id = "wield", frames = IndexedSeq(0, 1, 2), delay = 0.08, loop = false)
  )
)
