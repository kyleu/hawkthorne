/* Generated File */
package models.data.weapon

import models.animation.Animation
import models.template.weapon.WeaponTemplate

object Scythe extends WeaponTemplate(
  key = "scythe",
  name = "Scythe",
  width = 30,
  height = 61,
  hitAudioClip = Some("sword_hit"),
  swingAudioClip = Some("sword_air"),
  unuseAudioClip = None,
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(0), delay = 1.0, loop = false),
    Animation(id = "wield", frames = IndexedSeq(0, 1, 2), delay = 0.2, loop = false)
  )
)
