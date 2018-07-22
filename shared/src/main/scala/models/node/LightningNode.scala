package models.node

import models.asset.Asset
import util.JsonSerializers._

object LightningNode {
  val key = "lightning"
  implicit val jsonEncoder: Encoder[LightningNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[LightningNode] = deriveDecoder
}

case class LightningNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int,
    override val rotation: Int,
    override val visible: Boolean
) extends Node(LightningNode.key) {
  override val actualHeight = 336

  override val assets = Seq(Asset.Spritesheet(s"cornelius.lightning", s"images/cutscenes/lightning.png", actualWidth, actualHeight))
}
