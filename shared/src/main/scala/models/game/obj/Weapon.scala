package models.game.obj

import util.JsonSerializers._

object Weapon {
  implicit val jsonEncoder: Encoder[Weapon] = deriveEncoder
  implicit val jsonDecoder: Decoder[Weapon] = deriveDecoder

  val key = "weapon"
}

final case class Weapon(
    override val id: Int,
    override val n: String,
    override val loc: util.Rectangle,
    override val vis: Boolean
) extends GameObject(Weapon.key)
