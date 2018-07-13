package models.node

import util.JsonSerializers._

object HiddenDoorTriggerNode {
  val key = "hiddendoortrigger"
  implicit val jsonEncoder: Encoder[HiddenDoorTriggerNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[HiddenDoorTriggerNode] = deriveDecoder
}

case class HiddenDoorTriggerNode(
    override val x: Int,
    override val y: Int,
    override val width: Int = 0,
    override val height: Int = 0
) extends Node(HiddenDoorTriggerNode.key, x, y, width, height)
