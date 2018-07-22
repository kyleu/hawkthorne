package models.node

import models.asset.Asset
import util.JsonSerializers._

object OvalNode {
  val key = "oval"
  implicit val jsonEncoder: Encoder[OvalNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[OvalNode] = deriveDecoder
}

case class OvalNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int,
    override val rotation: Int,
    override val visible: Boolean
) extends Node(OvalNode.key) {
  override val assets = Seq(Asset.Spritesheet(s"cornelius.oval", s"images/cutscenes/corn_circles.png", actualWidth, actualWidth))
}
