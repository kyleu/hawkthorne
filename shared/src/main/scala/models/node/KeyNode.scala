package models.node

import util.JsonSerializers._

object KeyNode {
  object Props {
    implicit val jsonEncoder: Encoder[Props] = deriveEncoder
    implicit val jsonDecoder: Decoder[Props] = deriveDecoder
  }

  case class Props(info: String)

  val key = "key"
  implicit val jsonEncoder: Encoder[KeyNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[KeyNode] = deriveDecoder
}

case class KeyNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int,
    override val rotation: Int,
    override val visible: Boolean,
    properties: Option[KeyNode.Props]
) extends Node(KeyNode.key)
