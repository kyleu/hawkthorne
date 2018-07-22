package models.node

import models.asset.Asset
import util.JsonSerializers._

object HeadNode {
  val key = "head"
  implicit val jsonEncoder: Encoder[HeadNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[HeadNode] = deriveDecoder
}

case class HeadNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int,
    override val rotation: Int,
    override val visible: Boolean
) extends Node(HeadNode.key) {
  override val assets = Seq(Asset.Spritesheet(s"cornelius.head", s"images/cutscenes/cornelius_head.png", actualWidth, actualHeight))
}
