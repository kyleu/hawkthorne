package models.game.obj

import util.JsonSerializers._

object KillingFloor {
  implicit val jsonEncoder: Encoder[KillingFloor] = deriveEncoder
  implicit val jsonDecoder: Decoder[KillingFloor] = deriveDecoder

  val key = "killingFloor"
}

final case class KillingFloor(
    override val id: Int,
    override val n: String,
    override val loc: util.Rectangle,
    override val vis: Boolean
) extends GameObject(KillingFloor.key)
