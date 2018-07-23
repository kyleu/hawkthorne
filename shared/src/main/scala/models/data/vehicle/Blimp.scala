/* Generated File */
package models.data.vehicle

import models.animation.Animation
import models.template.vehicle.VehicleTemplate

object Blimp extends VehicleTemplate(
  key = "blimp",
  name = "Blimp",
  width = 199,
  height = 206,
  animations = Seq(Animation(id = "default", frames = IndexedSeq(0), delay = 0.1, loop = false))
)
