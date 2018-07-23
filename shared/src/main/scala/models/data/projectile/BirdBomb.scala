/* Generated File */
package models.data.projectile

import models.animation.Animation
import models.template.projectile.ProjectileTemplate

object BirdBomb extends ProjectileTemplate(
  key = "birdbomb",
  name = "BirdBomb",
  width = 9,
  height = 7,
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(0), delay = 0.2, loop = true),
    Animation(id = "thrown", frames = IndexedSeq(0), delay = 0.2, loop = true),
    Animation(id = "finish", frames = IndexedSeq(0), delay = 0.2, loop = true)
  )
)
