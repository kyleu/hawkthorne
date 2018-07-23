/* Generated File */
package models.data.vehicle

import models.animation.Animation
import models.template.vehicle.VehicleTemplate

object GolfCart extends VehicleTemplate(
  key = "golfcart",
  name = "GolfCart",
  width = 56,
  height = 39,
  animations = Seq(Animation(id = "default", frames = IndexedSeq(0), delay = 0.1, loop = false))
)
