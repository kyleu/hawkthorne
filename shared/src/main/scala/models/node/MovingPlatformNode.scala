package models.node

import util.JsonSerializers._

object MovingPlatformNode {
  val key = "movingplatform"
  implicit val jsonEncoder: Encoder[MovingPlatformNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[MovingPlatformNode] = deriveDecoder
}

case class MovingPlatformNode(
    override val x: Int,
    override val y: Int,
    override val width: Int = 0,
    override val height: Int = 0
) extends Node(MovingPlatformNode.key, x, y, width, height)
