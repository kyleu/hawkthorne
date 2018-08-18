package models.game.obj

import util.JsonSerializers._

object Projectile {
  implicit val jsonEncoder: Encoder[Projectile] = deriveEncoder
  implicit val jsonDecoder: Decoder[Projectile] = deriveDecoder

  val key = "projectile"
}

final case class Projectile(
    override val id: Int,
    override val n: String,
    override val loc: util.Rectangle,
    override val vis: Boolean
) extends GameObject(Projectile.key)
