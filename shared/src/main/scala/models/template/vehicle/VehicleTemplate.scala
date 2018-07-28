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
) {
  val defaultAnimation = animations.find(_.id == "default").getOrElse {
    throw new IllegalStateException(s"Missing default animation for [$key] among [${animations.map(_.id).mkString(", ")}]")
  }

  val animationMap = animations.map(a => a.id -> a).toMap
}

