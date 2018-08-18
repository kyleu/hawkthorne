package models.game.obj

import util.JsonSerializers._

object Info {
  implicit val jsonEncoder: Encoder[Info] = deriveEncoder
  implicit val jsonDecoder: Decoder[Info] = deriveDecoder

  val key = "info"
}

final case class Info(
    override val id: Int,
    override val n: String,
    override val loc: util.Rectangle,
    override val vis: Boolean,
    content: String
) extends GameObject(Info.key)
