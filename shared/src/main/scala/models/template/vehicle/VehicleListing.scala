/* Generated File */
package models.template.vehicle

import models.data.vehicle._

object VehicleListing {
  val all = Seq(
    Bomb, GolfCart, Helicopter, Dinosaur, Blimp, Robot
  )

  def withKey(key: String) = all.find(_.key == key).getOrElse(throw new IllegalStateException(s"No vehicle [$key]."))
}
