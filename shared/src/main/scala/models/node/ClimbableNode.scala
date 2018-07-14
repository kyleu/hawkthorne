package models.node

import util.JsonSerializers._

object ClimbableNode {
  val key = "climbable"
  implicit val jsonEncoder: Encoder[ClimbableNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[ClimbableNode] = deriveDecoder
}

case class ClimbableNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int
) extends Node(ClimbableNode.key)
