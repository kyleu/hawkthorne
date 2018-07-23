package models.node

import models.asset.Asset
import util.JsonSerializers._

object CowNode {
  val key = "cow"
  implicit val jsonEncoder: Encoder[CowNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[CowNode] = deriveDecoder
}

final case class CowNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int,
    override val rotation: Int,
    override val visible: Boolean
) extends Node(CowNode.key) {
  override def actualName = "cow"
  override val assets = Seq(Asset.Spritesheet(s"cow", s"images/sprites/town/cow.png", 114, 60))
}
