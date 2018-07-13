package models.node

import util.JsonSerializers._

object SceneTriggerNode {
  val key = "scenetrigger"
  implicit val jsonEncoder: Encoder[SceneTriggerNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[SceneTriggerNode] = deriveDecoder
}

case class SceneTriggerNode(
    override val x: Int,
    override val y: Int,
    override val width: Int = 0,
    override val height: Int = 0
) extends Node(SceneTriggerNode.key, x, y, width, height)
