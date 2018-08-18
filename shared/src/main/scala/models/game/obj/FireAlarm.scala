package models.game.obj

import util.JsonSerializers._

object FireAlarm {
  implicit val jsonEncoder: Encoder[FireAlarm] = deriveEncoder
  implicit val jsonDecoder: Decoder[FireAlarm] = deriveDecoder

  val key = "fireAlarm"
}

final case class FireAlarm(
    override val id: Int,
    override val n: String,
    override val loc: util.Rectangle,
    override val vis: Boolean
) extends GameObject(FireAlarm.key)
