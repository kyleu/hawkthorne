package models.template.enemy

import models.animation.Animation
import util.JsonSerializers._

object EnemyTemplate {
  implicit val jsonEncoder: Encoder[EnemyTemplate] = deriveEncoder
  implicit val jsonDecoder: Decoder[EnemyTemplate] = deriveDecoder

  def withKey(key: String) = EnemyListing.all.find(_.key == key).getOrElse(throw new IllegalStateException(s"No npc [$key]."))
}

case class EnemyTemplate(
    key: String,
    name: String,
    width: Int,
    height: Int,
    damage: Int,
    hp: Int,
    isBoss: Boolean,
    passiveSound: Option[String],
    attackSounds: Seq[String],
    dieSound: Option[String],
    sounds: Seq[String],
    animations: Seq[Animation]
)
