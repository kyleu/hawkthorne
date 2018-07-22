package models.node

import util.JsonSerializers._
import util.Point

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
    override val rotation: Int,
    override val visible: Boolean,
    polygon: Option[Seq[Point]],
    polyline: Option[Seq[Point]],
    properties: Option[SimpleNode.Props]
) extends Node(SimpleNode.key) {
  val primary = properties.exists(_.primary.contains("true"))

  override def actualName = if (primary) { "primary" } else { super.actualName }

  override def actualX = polygon match {
    case Some(poly) => super.actualX + poly.map(_.x).min
    case None => super.actualX
  }
  override def actualY = polygon match {
    case Some(poly) => super.actualY + poly.map(_.y).min
    case None => super.actualY
  }
}
