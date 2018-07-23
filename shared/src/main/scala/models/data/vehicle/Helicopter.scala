/* Generated File */
package models.data.vehicle

import models.animation.Animation
import models.template.vehicle.VehicleTemplate

object Helicopter extends VehicleTemplate(
  key = "helicopter",
  name = "Helicopter",
  width = 246,
  height = 224,
  animations = Seq(Animation(id = "default", frames = IndexedSeq(0), delay = 0.1, loop = false))
)
