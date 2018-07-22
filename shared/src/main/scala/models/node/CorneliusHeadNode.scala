package models.node

import models.asset.Asset
import util.JsonSerializers._

object CorneliusHeadNode {
  val key = "cornelius_head"
  implicit val jsonEncoder: Encoder[CorneliusHeadNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[CorneliusHeadNode] = deriveDecoder
}

case class CorneliusHeadNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int,
    override val rotation: Int,
    override val visible: Boolean
) extends Node(CorneliusHeadNode.key) {
  override val assets = Seq(Asset.Spritesheet("cornelius", "images/cornelius_head_2.png", 148, 195))
}
