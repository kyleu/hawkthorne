package models.node

import util.JsonSerializers._

object BuildingNode {
  val key = "building"
  implicit val jsonEncoder: Encoder[BuildingNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[BuildingNode] = deriveDecoder
}

case class BuildingNode(
    override val x: Int,
    override val y: Int,
    override val width: Int = 0,
    override val height: Int = 0
) extends Node(BuildingNode.key, x, y, width, height)
