/* Generated File */
package models.data.projectile

import models.animation.Animation
import models.template.projectile.ProjectileTemplate

object GhostPepper extends ProjectileTemplate(
  key = "ghost_pepper",
  name = "GhostPepper",
  width = 24,
  height = 74,
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(0, 1, 2, 1), delay = 0.3, loop = true),
    Animation(id = "thrown", frames = IndexedSeq(0, 1, 2, 1), delay = 0.3, loop = true),
    Animation(id = "explode", frames = IndexedSeq(3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14), delay = 0.08, loop = false),
    Animation(id = "finish", frames = IndexedSeq(14), delay = 1.0, loop = false)
  )
)
