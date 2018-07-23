/* Generated File */
package models.data.projectile

import models.animation.Animation
import models.template.projectile.ProjectileTemplate

object Lightning extends ProjectileTemplate(
  key = "lightning",
  name = "Lightning",
  width = 100,
  height = 30,
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(0, 1, 2), delay = 0.1, loop = true),
    Animation(id = "thrown", frames = IndexedSeq(0, 1, 2), delay = 0.1, loop = true),
    Animation(id = "finish", frames = IndexedSeq(0), delay = 1.0, loop = false)
  )
)
