package models.game.obj

import util.JsonSerializers._

object Consumable {
  implicit val jsonEncoder: Encoder[Consumable] = deriveEncoder
  implicit val jsonDecoder: Decoder[Consumable] = deriveDecoder

  val key = "consumable"
}

final case class Consumable(
    override val id: Int,
    override val n: String,
    override val loc: util.Rectangle,
    override val vis: Boolean
) extends GameObject(Consumable.key)
