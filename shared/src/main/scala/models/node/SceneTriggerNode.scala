package models.node

import util.JsonSerializers._

object SceneTriggerNode {
  object Props {
    implicit val jsonEncoder: Encoder[Props] = deriveEncoder
    implicit val jsonDecoder: Decoder[Props] = deriveDecoder
  }

  final case class Props(cutscene: String)

  val key = "scenetrigger"
  implicit val jsonEncoder: Encoder[SceneTriggerNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[SceneTriggerNode] = deriveDecoder
}

final case class SceneTriggerNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int,
    override val rotation: Int,
    override val visible: Boolean,
    properties: SceneTriggerNode.Props
) extends Node(SceneTriggerNode.key)
