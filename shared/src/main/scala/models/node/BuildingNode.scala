package models.node

import util.JsonSerializers._

object BuildingNode {
  val key = "building"
  implicit val jsonEncoder: Encoder[BuildingNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[BuildingNode] = deriveDecoder
}

case class BuildingNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int
) extends Node(BuildingNode.key)
