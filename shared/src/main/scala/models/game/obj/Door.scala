package models.game.obj

import util.JsonSerializers._

object Door {
  implicit val jsonEncoder: Encoder[Door] = deriveEncoder
  implicit val jsonDecoder: Decoder[Door] = deriveDecoder

  val key = "door"
}

final case class Door(
    override val id: Int,
    override val n: String,
    override val loc: util.Rectangle,
    override val vis: Boolean
) extends GameObject(Door.key)
