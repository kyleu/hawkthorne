package models.game.obj

import util.JsonSerializers._

object Key {
  implicit val jsonEncoder: Encoder[Key] = deriveEncoder
  implicit val jsonDecoder: Decoder[Key] = deriveDecoder

  val key = "key"
}

final case class Key(
    override val id: Int,
    override val n: String,
    override val loc: util.Rectangle,
    override val vis: Boolean
) extends GameObject(Key.key)
