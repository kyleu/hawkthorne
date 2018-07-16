package models.node

import util.JsonSerializers._

object InfoNode {
  object Props {
    implicit val jsonEncoder: Encoder[Props] = deriveEncoder
    implicit val jsonDecoder: Decoder[Props] = deriveDecoder
  }

  case class Props(info: String, sprite: Option[String])

  val key = "info"
  implicit val jsonEncoder: Encoder[InfoNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[InfoNode] = deriveDecoder
}

case class InfoNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int,
    override val rotation: Option[Int],
    override val visible: Option[Boolean],
    properties: InfoNode.Props
) extends Node(InfoNode.key)
