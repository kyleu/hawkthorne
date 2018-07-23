/* Generated File */
package models.data.projectile

import models.animation.Animation
import models.template.projectile.ProjectileTemplate

object Icicle extends ProjectileTemplate(
  key = "icicle",
  name = "Icicle",
  width = 16,
  height = 16,
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(0), delay = 1.0, loop = false),
    Animation(id = "thrown", frames = IndexedSeq(0), delay = 1.0, loop = false),
    Animation(id = "finish", frames = IndexedSeq(0), delay = 1.0, loop = false)
  )
)
