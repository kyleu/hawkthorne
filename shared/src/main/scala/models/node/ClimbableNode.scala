package models.node

import util.JsonSerializers._

object ClimbableNode {
  val key = "climbable"
  implicit val jsonEncoder: Encoder[ClimbableNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[ClimbableNode] = deriveDecoder
}

case class ClimbableNode(
    override val x: Int,
    override val y: Int,
    override val width: Int = 0,
    override val height: Int = 0
) extends Node(ClimbableNode.key, x, y, width, height)
