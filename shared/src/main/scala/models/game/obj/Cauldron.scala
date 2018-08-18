package models.game.obj

import util.JsonSerializers._

object Cauldron {
  implicit val jsonEncoder: Encoder[Cauldron] = deriveEncoder
  implicit val jsonDecoder: Decoder[Cauldron] = deriveDecoder

  val key = "cauldron"
}

final case class Cauldron(
    override val id: Int,
    override val n: String,
    override val loc: util.Rectangle,
    override val vis: Boolean
) extends GameObject(Cauldron.key)
