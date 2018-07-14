package models.node

import util.JsonSerializers._

object ThrowableNode {
  val key = "throwable"
  implicit val jsonEncoder: Encoder[ThrowableNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[ThrowableNode] = deriveDecoder
}

case class ThrowableNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int
) extends Node(ThrowableNode.key)