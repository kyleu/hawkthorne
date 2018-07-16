package models.node

import util.JsonSerializers._

object DetailNode {
  object Props {
    implicit val jsonEncoder: Encoder[Props] = deriveEncoder
    implicit val jsonDecoder: Decoder[Props] = deriveDecoder
  }

  case class Props(category: String)

  val key = "detail"
  implicit val jsonEncoder: Encoder[DetailNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[DetailNode] = deriveDecoder
}

case class DetailNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int,
    override val rotation: Option[Int],
    override val visible: Option[Boolean],
    properties: DetailNode.Props
) extends Node(DetailNode.key)
