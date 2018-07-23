/* Generated File */
package models.data.weapon

import models.animation.Animation
import models.template.weapon.WeaponTemplate

object TruestWrench extends WeaponTemplate(
  key = "truestwrench",
  name = "TruestWrench",
  width = 30,
  height = 40,
  hitAudioClip = Some("anvil"),
  swingAudioClip = None,
  unuseAudioClip = None,
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(0), delay = 1.0, loop = false),
    Animation(id = "wield", frames = IndexedSeq(0, 1, 2, 1), delay = 0.07, loop = false)
  )
)
