package models.node

import util.JsonSerializers._

object MaterialNode {
  object Props {
    implicit val jsonEncoder: Encoder[Props] = deriveEncoder
    implicit val jsonDecoder: Decoder[Props] = deriveDecoder
  }

  case class Props(info: Option[String], persistent: Option[String])

  val key = "material"
  implicit val jsonEncoder: Encoder[MaterialNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[MaterialNode] = deriveDecoder
}

case class MaterialNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int,
    override val rotation: Int,
    override val visible: Boolean,
    properties: Option[MaterialNode.Props]
) extends Node(MaterialNode.key)
