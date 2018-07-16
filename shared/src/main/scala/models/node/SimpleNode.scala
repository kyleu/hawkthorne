package models.node

import util.JsonSerializers._

object SimpleNode {
  object Props {
    implicit val jsonEncoder: Encoder[Props] = deriveEncoder
    implicit val jsonDecoder: Decoder[Props] = deriveDecoder
  }

  case class Props(blocks: Option[String], height: Option[String], primary: Option[String])

  val key = "simple"
  implicit val jsonEncoder: Encoder[SimpleNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[SimpleNode] = deriveDecoder
}

case class SimpleNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int,
    override val rotation: Option[Int],
    override val visible: Option[Boolean],
    polygon: Option[Seq[Node.Point]],
    polyline: Option[Seq[Node.Point]],
    properties: Option[SimpleNode.Props]
) extends Node(SimpleNode.key)
