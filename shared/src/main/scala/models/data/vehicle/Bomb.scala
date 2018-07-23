/* Generated File */
package models.data.vehicle

import models.animation.Animation
import models.template.vehicle.VehicleTemplate

object Bomb extends VehicleTemplate(
  key = "bomb",
  name = "Bomb",
  width = 423,
  height = 201,
  animations = Seq(Animation(id = "default", frames = IndexedSeq(0), delay = 0.1, loop = false))
)
