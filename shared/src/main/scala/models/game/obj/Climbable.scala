package models.game.obj

import util.JsonSerializers._

object Climbable {
  implicit val jsonEncoder: Encoder[Climbable] = deriveEncoder
  implicit val jsonDecoder: Decoder[Climbable] = deriveDecoder

  val key = "climbable"
}

final case class Climbable(
    override val id: Int,
    override val n: String,
    override val loc: util.Rectangle,
    override val vis: Boolean
) extends GameObject(Climbable.key)
