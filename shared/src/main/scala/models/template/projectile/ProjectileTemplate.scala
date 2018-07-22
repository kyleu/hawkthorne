package models.template.projectile

import models.animation.Animation
import util.JsonSerializers._

object ProjectileTemplate {
  implicit val jsonEncoder: Encoder[ProjectileTemplate] = deriveEncoder
  implicit val jsonDecoder: Decoder[ProjectileTemplate] = deriveDecoder

  def withKey(key: String) = ProjectileListing.all.find(_.key == key).getOrElse(throw new IllegalStateException(s"No npc [$key]."))
}

case class ProjectileTemplate(
    key: String,
    name: String,
    width: Int,
    height: Int,
    animations: Seq[Animation]
)
