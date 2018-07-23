/* Generated File */
package models.data.projectile

import models.animation.Animation
import models.template.projectile.ProjectileTemplate

object WaterSpout extends ProjectileTemplate(
  key = "waterSpout",
  name = "WaterSpout",
  width = 24,
  height = 72,
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(0, 1, 2, 3), delay = 0.15, loop = true),
    Animation(id = "thrown", frames = IndexedSeq(0, 1, 2, 3), delay = 0.15, loop = true),
    Animation(id = "explode", frames = IndexedSeq(4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14), delay = 0.08, loop = false),
    Animation(id = "finish", frames = IndexedSeq(14), delay = 1.0, loop = false)
  )
)
