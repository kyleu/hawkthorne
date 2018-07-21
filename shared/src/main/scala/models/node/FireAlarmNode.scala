package models.node

import util.JsonSerializers._

object FireAlarmNode {
  val key = "firealarm"
  implicit val jsonEncoder: Encoder[FireAlarmNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[FireAlarmNode] = deriveDecoder
}

case class FireAlarmNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int,
    override val rotation: Int,
    override val visible: Boolean
) extends Node(FireAlarmNode.key)
