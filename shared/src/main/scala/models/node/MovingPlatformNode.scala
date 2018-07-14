package models.node

import util.JsonSerializers._

object MovingPlatformNode {
  val key = "movingplatform"
  implicit val jsonEncoder: Encoder[MovingPlatformNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[MovingPlatformNode] = deriveDecoder
}

case class MovingPlatformNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int
) extends Node(MovingPlatformNode.key)
