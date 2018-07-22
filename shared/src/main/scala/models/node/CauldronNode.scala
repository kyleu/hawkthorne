package models.node

import models.asset.Asset
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
    override val rotation: Int,
    override val visible: Boolean,
    properties: Option[CauldronNode.Props]
) extends Node(CauldronNode.key) {

  override val actualName = if (name.trim.isEmpty) { "cauldron" } else { name }

  override def assets = Seq(Asset.Image(s"cauldron.$actualName", s"images/potions/$actualName.png"))
}
