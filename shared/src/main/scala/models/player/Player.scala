package models.player

import java.util.UUID

import util.JsonSerializers._

object Player {
  implicit val jsonEncoder: Encoder[Player] = deriveEncoder
  implicit val jsonDecoder: Decoder[Player] = deriveDecoder

  val default = Player()
}

case class Player(
    idx: Int = 0,
    user: UUID = UUID.fromString("00000000-0000-0000-0000-000000000000"),
    health: Int = 100,
    templateKey: String = "jeff",
    costumeKey: String = "base"
) {
  val template = CharacterTemplate.withKey(templateKey)
  val costume = template.costume(costumeKey)
  val spritesheet = (templateKey + "." + costumeKey, "images/character" + "/" + templateKey + "/" + costumeKey + ".png", 48, 48)
}
