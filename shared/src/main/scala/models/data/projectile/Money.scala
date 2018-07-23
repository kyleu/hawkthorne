/* Generated File */
package models.data.projectile

import models.animation.Animation
import models.template.projectile.ProjectileTemplate

object Money extends ProjectileTemplate(
  key = "money",
  name = "Money",
  width = 28,
  height = 20,
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(0, 1), delay = 0.2, loop = true),
    Animation(id = "thrown", frames = IndexedSeq(0, 1), delay = 0.2, loop = true),
    Animation(id = "finish", frames = IndexedSeq(1), delay = 0.2, loop = true)
  )
)
