package models.player

import java.util.UUID

import models.template.character.CharacterListing
import util.JsonSerializers._

import scala.util.Random

object Player {
  implicit val jsonEncoder: Encoder[Player] = deriveEncoder
  implicit val jsonDecoder: Decoder[Player] = deriveDecoder

  def random(id: UUID, idx: Int) = {
    val template = CharacterListing.greendaleSeven(Random.nextInt(CharacterListing.greendaleSeven.size))
    Player(id = id, idx = idx, attributes = PlayerAttributes(), templateKey = template.key, costumeKey = template.randomCostume.key)
  }
}

final case class Player(
    id: UUID,
    idx: Int,
    attributes: PlayerAttributes = PlayerAttributes(),
    templateKey: String = "jeff",
    costumeKey: String = "base"
) {
  val template = CharacterListing.withKey(templateKey)
  val costume = template.costume(costumeKey)
  val spritesheet = (templateKey + "." + costumeKey, s"images/characters/$templateKey/$costumeKey.png", 48, 48)
}
