package models.node

import models.asset.Asset
import util.JsonSerializers._

object DealerNode {
  val key = "dealer"
  implicit val jsonEncoder: Encoder[DealerNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[DealerNode] = deriveDecoder
}

final case class DealerNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int,
    override val rotation: Int,
    override val visible: Boolean
) extends Node(DealerNode.key) {
  override val assets = Seq(Asset.Spritesheet(t, s"images/sprites/town/dealer.png", 72, 72), Asset.sfx("letsPlayPoker"))
}
