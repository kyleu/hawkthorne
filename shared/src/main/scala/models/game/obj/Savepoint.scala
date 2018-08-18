package models.game.obj

import util.JsonSerializers._

object Savepoint {
  implicit val jsonEncoder: Encoder[Savepoint] = deriveEncoder
  implicit val jsonDecoder: Decoder[Savepoint] = deriveDecoder

  val key = "savepoint"
}

final case class Savepoint(
    override val id: Int,
    override val n: String,
    override val loc: util.Rectangle,
    override val vis: Boolean
) extends GameObject(Savepoint.key)
