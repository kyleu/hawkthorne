package models.node

import util.JsonSerializers._

object ThrowableNode {
  val key = "throwable"
  implicit val jsonEncoder: Encoder[ThrowableNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[ThrowableNode] = deriveDecoder
}

case class ThrowableNode(
    override val x: Int,
    override val y: Int,
    override val width: Int = 0,
    override val height: Int = 0
) extends Node(ThrowableNode.key, x, y, width, height)
