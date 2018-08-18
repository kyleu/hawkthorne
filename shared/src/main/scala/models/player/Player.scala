package models.player

import java.util.UUID

import models.template.character.CharacterListing
import util.JsonSerializers._

import scala.util.Random

object Player {
  implicit val jsonEncoder: Encoder[Player] = deriveEncoder
  implicit val jsonDecoder: Decoder[Player] = deriveDecoder

  val default = Player()

  def random(id: UUID) = {
    val template = CharacterListing.greendaleSeven(Random.nextInt(CharacterListing.greendaleSeven.size))
    Player(id = id, attributes = PlayerAttributes(), templateKey = template.key, costumeKey = template.randomCostume.key)
  }
}

final case class Player(
    id: UUID = UUID.fromString("00000000-0000-0000-0000-000000000000"),
    var x: Double = 0.0,
    var y: Double = 0.0,
    attributes: PlayerAttributes = PlayerAttributes(),
    templateKey: String = "jeff",
    costumeKey: String = "base"
) {
  val template = CharacterListing.withKey(templateKey)
  val costume = template.costume(costumeKey)
  val spritesheet = (templateKey + "." + costumeKey, s"images/characters/$templateKey/$costumeKey.png", 48, 48)
}
