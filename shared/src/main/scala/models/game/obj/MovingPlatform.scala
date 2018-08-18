package models.game.obj

import util.JsonSerializers._

object MovingPlatform {
  implicit val jsonEncoder: Encoder[MovingPlatform] = deriveEncoder
  implicit val jsonDecoder: Decoder[MovingPlatform] = deriveDecoder

  val key = "movingPlatform"
}

final case class MovingPlatform(
    override val id: Int,
    override val n: String,
    override val loc: util.Rectangle,
    override val vis: Boolean
) extends GameObject(MovingPlatform.key)
