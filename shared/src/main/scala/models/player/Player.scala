package models.player

import models.character.Characters
import util.JsonSerializers._

object Player {
  implicit val jsonEncoder: Encoder[Player] = deriveEncoder
  implicit val jsonDecoder: Decoder[Player] = deriveDecoder

  val default = Player("abed", "base")
}

case class Player(
    templateKey: String,
    costumeKey: String
) {
  val template = Characters.withKey(templateKey)
  val costume = template.costume(costumeKey)
}
