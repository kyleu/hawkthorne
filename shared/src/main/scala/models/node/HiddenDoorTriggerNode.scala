package models.node

import util.JsonSerializers._

object HiddenDoorTriggerNode {
  val key = "hiddendoortrigger"
  implicit val jsonEncoder: Encoder[HiddenDoorTriggerNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[HiddenDoorTriggerNode] = deriveDecoder
}

case class HiddenDoorTriggerNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int
) extends Node(HiddenDoorTriggerNode.key)
