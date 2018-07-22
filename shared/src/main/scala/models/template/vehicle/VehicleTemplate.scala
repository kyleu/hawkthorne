package models.template.vehicle

import models.animation.Animation
import util.JsonSerializers._

object VehicleTemplate {
  implicit val jsonEncoder: Encoder[VehicleTemplate] = deriveEncoder
  implicit val jsonDecoder: Decoder[VehicleTemplate] = deriveDecoder

  def withKey(key: String) = VehicleListing.all.find(_.key == key).getOrElse(throw new IllegalStateException(s"No weapon [$key]."))
}

case class VehicleTemplate(
    key: String,
    name: String,
    width: Int,
    height: Int,
    animations: Seq[Animation]
)

