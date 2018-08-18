package models.game.obj

import util.JsonSerializers._

object Spawn {
  implicit val jsonEncoder: Encoder[Spawn] = deriveEncoder
  implicit val jsonDecoder: Decoder[Spawn] = deriveDecoder

  val key = "spawn"
}

final case class Spawn(
    override val id: Int,
    override val n: String,
    override val loc: util.Rectangle,
    override val vis: Boolean
) extends GameObject(Spawn.key)
