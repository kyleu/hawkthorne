/* Generated File */
package models.data.projectile

import models.animation.Animation
import models.template.projectile.ProjectileTemplate

object ThrowingTorch extends ProjectileTemplate(
  key = "throwingtorch",
  name = "ThrowingTorch",
  width = 24,
  height = 44,
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(0, 1, 2, 3, 4, 5), delay = 0.09, loop = true),
    Animation(id = "thrown", frames = IndexedSeq(6, 7, 8, 9, 10, 11, 12), delay = 0.09, loop = true),
    Animation(id = "finish", frames = IndexedSeq(0), delay = 1.0, loop = false)
  )
)
