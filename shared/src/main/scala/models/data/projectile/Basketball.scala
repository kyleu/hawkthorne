/* Generated File */
package models.data.projectile

import models.animation.Animation
import models.template.projectile.ProjectileTemplate

object Basketball extends ProjectileTemplate(
  key = "basketball",
  name = "Basketball",
  width = 18,
  height = 16,
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(0), delay = 1.0, loop = false),
    Animation(id = "thrown", frames = IndexedSeq(0), delay = 1.0, loop = false),
    Animation(id = "finish", frames = IndexedSeq(0), delay = 1.0, loop = false)
  )
)
