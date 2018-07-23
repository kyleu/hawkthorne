/* Generated File */
package models.data.projectile

import models.animation.Animation
import models.template.projectile.ProjectileTemplate

object BenzalkFire extends ProjectileTemplate(
  key = "benzalkFire",
  name = "BenzalkFire",
  width = 72,
  height = 33,
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(0), delay = 1.0, loop = false),
    Animation(id = "thrown", frames = IndexedSeq(0, 1, 2, 3), delay = 0.25, loop = true),
    Animation(id = "finish", frames = IndexedSeq(3), delay = 1.0, loop = false)
  )
)
