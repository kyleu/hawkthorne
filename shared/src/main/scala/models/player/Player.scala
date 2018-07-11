package models.player

import models.character.{CharacterTemplate, Characters, Costume}
import models.data.character.Abed
import util.JsonSerializers._

object Player {
  implicit val jsonEncoder: Encoder[Player] = deriveEncoder
  implicit val jsonDecoder: Decoder[Player] = deriveDecoder

  val default = Player(Abed.key, Abed.costumes.head)
}

case class Player(
    templateKey: String,
    costume: Costume
) {
  val template = Characters.withKey(templateKey)
}
