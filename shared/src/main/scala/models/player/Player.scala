package models.player

import java.util.UUID

import models.game.GameObject
import util.JsonSerializers._
import util.Point

object Player {
  implicit val jsonEncoder: Encoder[Player] = deriveEncoder
  implicit val jsonDecoder: Decoder[Player] = deriveDecoder

  val default = Player()
}

final case class Player(
    idx: Int = 0,
    user: UUID = UUID.fromString("00000000-0000-0000-0000-000000000000"),
    health: Int = 100,
    templateKey: String = "jeff",
    costumeKey: String = "base"
) {
  val template = CharacterListing.withKey(templateKey)
  val costume = template.costume(costumeKey)
  val spritesheet = (templateKey + "." + costumeKey, s"images/characters/$templateKey/$costumeKey.png", 48, 48)

  def asNewGameObject(id: Int, idx: Int, spawn: Point) = {
    GameObject(t = "player", id = id, n = s"Player $idx (${template.name})", x = spawn.x.toDouble, y = spawn.y.toDouble, w = 48, h = 48)
  }
}
