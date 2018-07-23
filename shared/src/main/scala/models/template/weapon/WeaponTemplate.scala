package models.template.weapon

import models.animation.Animation
import util.JsonSerializers._

object WeaponTemplate {
  implicit val jsonEncoder: Encoder[WeaponTemplate] = deriveEncoder
  implicit val jsonDecoder: Decoder[WeaponTemplate] = deriveDecoder

  def withKey(key: String) = WeaponListing.all.find(_.key == key).getOrElse(throw new IllegalStateException(s"No weapon [$key]."))
}

final case class WeaponTemplate(
    key: String,
    name: String,
    width: Int,
    height: Int,
    hitAudioClip: Option[String],
    swingAudioClip: Option[String],
    unuseAudioClip: Option[String],
    animations: Seq[Animation]
) {
  val defaultAnimation = animations.find(_.id == "default").getOrElse {
    throw new IllegalStateException(s"Missing default animation for [$key] among [${animations.map(_.id).mkString(", ")}]")
  }

  val animationMap = animations.map(a => a.id -> a).toMap
}
