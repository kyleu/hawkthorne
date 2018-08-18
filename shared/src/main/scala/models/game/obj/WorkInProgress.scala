package models.game.obj

import util.JsonSerializers._

object WorkInProgress {
  implicit val jsonEncoder: Encoder[WorkInProgress] = deriveEncoder
  implicit val jsonDecoder: Decoder[WorkInProgress] = deriveDecoder

  val key = "wip"
}

final case class WorkInProgress(
    override val id: Int,
    override val n: String,
    override val loc: GameObject.Location,
    override val vis: Boolean,
    todo: String
) extends GameObject(WorkInProgress.key)
