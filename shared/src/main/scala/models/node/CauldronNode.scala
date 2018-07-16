package models.node

import util.JsonSerializers._

object CauldronNode {
  object Props {
    implicit val jsonEncoder: Encoder[Props] = deriveEncoder
    implicit val jsonDecoder: Decoder[Props] = deriveDecoder
  }

  case class Props(message: String)

  val key = "cauldron"
  implicit val jsonEncoder: Encoder[CauldronNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[CauldronNode] = deriveDecoder
}

case class CauldronNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int,
    override val rotation: Option[Int],
    override val visible: Option[Boolean],
    properties: Option[CauldronNode.Props]
) extends Node(CauldronNode.key)
