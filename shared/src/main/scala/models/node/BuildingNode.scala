package models.node

import util.JsonSerializers._

object BuildingNode {
  object Props {
    implicit val jsonEncoder: Encoder[Props] = deriveEncoder
    implicit val jsonDecoder: Decoder[Props] = deriveDecoder
  }

  case class Props(trigger: String)

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
    override val height: Int,
    override val rotation: Int,
    override val visible: Boolean,
    properties: Option[BuildingNode.Props]
) extends Node(BuildingNode.key)
