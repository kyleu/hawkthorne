package models.game.obj

import util.JsonSerializers._

object BreakableBlock {
  implicit val jsonEncoder: Encoder[BreakableBlock] = deriveEncoder
  implicit val jsonDecoder: Decoder[BreakableBlock] = deriveDecoder

  val key = "breakableBlock"
}

final case class BreakableBlock(
    override val id: Int,
    override val n: String,
    override val loc: util.Rectangle,
    override val vis: Boolean
) extends GameObject(BreakableBlock.key)
