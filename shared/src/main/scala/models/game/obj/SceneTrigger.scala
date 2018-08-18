package models.game.obj

import util.JsonSerializers._

object SceneTrigger {
  implicit val jsonEncoder: Encoder[SceneTrigger] = deriveEncoder
  implicit val jsonDecoder: Decoder[SceneTrigger] = deriveDecoder

  val key = "sceneTrigger"
}

final case class SceneTrigger(
    override val id: Int,
    override val n: String,
    override val loc: util.Rectangle,
    override val vis: Boolean
) extends GameObject(SceneTrigger.key)
