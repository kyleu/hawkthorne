package models.node

import util.JsonSerializers._

object SceneTriggerNode {
  val key = "scenetrigger"
  implicit val jsonEncoder: Encoder[SceneTriggerNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[SceneTriggerNode] = deriveDecoder
}

case class SceneTriggerNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int
) extends Node(SceneTriggerNode.key)
