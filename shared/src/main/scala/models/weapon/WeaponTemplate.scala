package models.weapon

import models.animation.Animation
import util.JsonSerializers._

object WeaponTemplate {
  implicit val jsonEncoder: Encoder[WeaponTemplate] = deriveEncoder
  implicit val jsonDecoder: Decoder[WeaponTemplate] = deriveDecoder

  def withKey(key: String) = WeaponListing.all.find(_.key == key).getOrElse(throw new IllegalStateException(s"No weapon [$key]."))
}

case class WeaponTemplate(
    key: String,
    name: String,
    width: Int,
    height: Int,
    animations: Seq[Animation]
)
