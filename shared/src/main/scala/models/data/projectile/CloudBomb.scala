/* Generated File */
package models.data.projectile

import models.animation.Animation
import models.template.projectile.ProjectileTemplate

object CloudBomb extends ProjectileTemplate(
  key = "cloudbomb",
  name = "CloudBomb",
  width = 9,
  height = 9,
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(0), delay = 0.2, loop = false),
    Animation(id = "thrown", frames = IndexedSeq(9, 10, 11, 12), delay = 0.2, loop = true),
    Animation(id = "finish", frames = IndexedSeq(0, 1, 2, 3, 4, 5, 6, 7, 8), delay = 0.22, loop = false)
  )
)
