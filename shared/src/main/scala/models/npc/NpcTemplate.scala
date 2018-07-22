package models.npc

import models.animation.Animation
import util.JsonSerializers._

object NpcTemplate {
  implicit val jsonEncoder: Encoder[NpcTemplate] = deriveEncoder
  implicit val jsonDecoder: Decoder[NpcTemplate] = deriveDecoder

  def withKey(key: String) = NpcListing.all.find(_.key == key).getOrElse(throw new IllegalStateException(s"No npc [$key]."))
}

case class NpcTemplate(
    key: String,
    name: String,
    width: Int,
    height: Int,
    greeting: Option[String],
    noInventory: Option[String],
    noCommands: Option[String],
    animations: Seq[Animation]
)
