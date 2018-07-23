/* Generated File */
package models.data.projectile

import models.animation.Animation
import models.template.projectile.ProjectileTemplate

object AcornBomb extends ProjectileTemplate(
  key = "acornBomb",
  name = "AcornBomb",
  width = 15,
  height = 15,
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(0), delay = 0.2, loop = true),
    Animation(id = "thrown", frames = IndexedSeq(0), delay = 0.1, loop = false),
    Animation(id = "finish", frames = IndexedSeq(1, 2, 3, 4), delay = 0.1, loop = false)
  )
)
