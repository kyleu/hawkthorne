package models.game.obj

import util.JsonSerializers._

object Enemy {
  implicit val jsonEncoder: Encoder[Enemy] = deriveEncoder
  implicit val jsonDecoder: Decoder[Enemy] = deriveDecoder

  val key = "enemy"
}

final case class Enemy(
    override val id: Int,
    override val n: String,
    override val loc: util.Rectangle,
    override val vis: Boolean
) extends GameObject(Enemy.key)
