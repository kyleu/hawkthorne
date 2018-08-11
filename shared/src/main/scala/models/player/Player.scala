package models.player

import java.util.UUID

import models.game.GameObject
import models.template.character.CharacterListing
import util.JsonSerializers._
import util.Point

import scala.util.Random

object Player {
  implicit val jsonEncoder: Encoder[Player] = deriveEncoder
  implicit val jsonDecoder: Decoder[Player] = deriveDecoder

  val default = Player()

  def randomFor(userId: UUID) = {
    val template = CharacterListing.greendaleSeven(Random.nextInt(CharacterListing.greendaleSeven.size))
    Player(user = userId, templateKey = template.key, costumeKey = template.randomCostume.key)
  }
}

final case class Player(
    user: UUID = UUID.fromString("00000000-0000-0000-0000-000000000000"),
    health: Int = 100,
    templateKey: String = "jeff",
    costumeKey: String = "base"
) {
  val template = CharacterListing.withKey(templateKey)
  val costume = template.costume(costumeKey)
  val spritesheet = (templateKey + "." + costumeKey, s"images/characters/$templateKey/$costumeKey.png", 48, 48)
}
