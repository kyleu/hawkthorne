package models.node

import util.JsonSerializers._

object SavepointNode {
  val key = "savepoint"
  implicit val jsonEncoder: Encoder[SavepointNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[SavepointNode] = deriveDecoder
}

case class SavepointNode(
    override val x: Int,
    override val y: Int,
    override val width: Int = 0,
    override val height: Int = 0
) extends Node(SavepointNode.key, x, y, width, height)
