/* Generated File */
package models.data.projectile

import models.animation.Animation
import models.template.projectile.ProjectileTemplate

object ThrowingAxe extends ProjectileTemplate(
  key = "throwingaxe",
  name = "ThrowingAxe",
  width = 16,
  height = 16,
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(0), delay = 1.0, loop = false),
    Animation(id = "thrown", frames = IndexedSeq(0, 1, 2, 3, 4, 5, 6), delay = 0.15, loop = true),
    Animation(id = "finish", frames = IndexedSeq(2), delay = 1.0, loop = false)
  )
)
