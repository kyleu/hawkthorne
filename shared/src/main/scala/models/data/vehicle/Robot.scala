/* Generated File */
package models.data.vehicle

import models.animation.Animation
import models.template.vehicle.VehicleTemplate

object Robot extends VehicleTemplate(
  key = "robot",
  name = "Robot",
  width = 216,
  height = 223,
  animations = Seq(Animation(id = "default", frames = IndexedSeq(0), delay = 0.1, loop = false))
)
