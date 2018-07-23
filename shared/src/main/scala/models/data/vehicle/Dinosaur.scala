/* Generated File */
package models.data.vehicle

import models.animation.Animation
import models.template.vehicle.VehicleTemplate

object Dinosaur extends VehicleTemplate(
  key = "dinosaur",
  name = "Dinosaur",
  width = 324,
  height = 194,
  animations = Seq(Animation(id = "default", frames = IndexedSeq(0), delay = 0.1, loop = false))
)
