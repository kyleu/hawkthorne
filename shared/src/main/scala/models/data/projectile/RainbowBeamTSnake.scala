/* Generated File */
package models.data.projectile

import models.animation.Animation
import models.template.projectile.ProjectileTemplate

object RainbowBeamTSnake extends ProjectileTemplate(
  key = "rainbowbeam_tsnake",
  name = "RainbowBeamTSnake",
  width = 32,
  height = 26,
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(0, 1, 2), delay = 0.25, loop = true),
    Animation(id = "thrown", frames = IndexedSeq(3, 4), delay = 0.25, loop = true),
    Animation(id = "finish", frames = IndexedSeq(4), delay = 1.0, loop = false)
  )
)
