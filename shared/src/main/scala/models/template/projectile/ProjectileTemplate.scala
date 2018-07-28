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
) {
  val defaultAnimation = animations.find(_.id == "default").getOrElse {
    throw new IllegalStateException(s"Missing default animation for [$key] among [${animations.map(_.id).mkString(", ")}]")
  }

  val animationMap = animations.map(a => a.id -> a).toMap
}
