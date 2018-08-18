package models.game.obj

import util.JsonSerializers._

object Material {
  implicit val jsonEncoder: Encoder[Material] = deriveEncoder
  implicit val jsonDecoder: Decoder[Material] = deriveDecoder

  val key = "material"
}

final case class Material(
    override val id: Int,
    override val n: String,
    override val loc: util.Rectangle,
    override val vis: Boolean
) extends GameObject(Material.key)
