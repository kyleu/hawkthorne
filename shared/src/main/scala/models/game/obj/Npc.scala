package models.game.obj

import util.JsonSerializers._

object Npc {
  implicit val jsonEncoder: Encoder[Npc] = deriveEncoder
  implicit val jsonDecoder: Decoder[Npc] = deriveDecoder

  val key = "npc"
}

final case class Npc(
    override val id: Int,
    override val n: String,
    override val loc: util.Rectangle,
    override val vis: Boolean
) extends GameObject(Npc.key)
