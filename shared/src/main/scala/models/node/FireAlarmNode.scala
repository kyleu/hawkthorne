package models.node

import util.JsonSerializers._

object FireAlarmNode {
  val key = "firealarm"
  implicit val jsonEncoder: Encoder[FireAlarmNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[FireAlarmNode] = deriveDecoder
}

case class FireAlarmNode(
    override val x: Int,
    override val y: Int,
    override val width: Int = 0,
    override val height: Int = 0
) extends Node(FireAlarmNode.key, x, y, width, height)
