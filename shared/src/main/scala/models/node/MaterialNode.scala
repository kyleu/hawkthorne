package models.node

import models.asset.Asset
import util.JsonSerializers._

object MaterialNode {
  object Props {
    implicit val jsonEncoder: Encoder[Props] = deriveEncoder
    implicit val jsonDecoder: Decoder[Props] = deriveDecoder
  }

  final case class Props(info: Option[String], persistent: Option[String])

  val key = "material"
  implicit val jsonEncoder: Encoder[MaterialNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[MaterialNode] = deriveDecoder
}

final case class MaterialNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int,
    override val rotation: Int,
    override val visible: Boolean,
    properties: Option[MaterialNode.Props]
) extends Node(MaterialNode.key) {
  override val actualWidth = if (name.startsWith("buddha")) { 35 } else { super.actualWidth }
  override val actualHeight = if (name.startsWith("buddha")) { 30 } else { super.actualHeight }

  override val assets = Seq(Asset.Image(s"material.$actualName", s"images/materials/$actualName.png"))
}
