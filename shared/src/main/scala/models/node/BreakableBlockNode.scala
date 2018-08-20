package models.node

import models.asset.Asset
import models.game.obj.BreakableBlock
import util.JsonSerializers._
import util.{DoublePoint, Polygon}

object BreakableBlockNode {
  object Props {
    implicit val jsonEncoder: Encoder[Props] = deriveEncoder
    implicit val jsonDecoder: Decoder[Props] = deriveDecoder
  }

  final case class Props(
      brokenBy: Option[String],
      crack: Option[String],
      dying_animation: Option[String],
      explode: Option[String],
      flipY: Option[String],
      flipped: Option[String],
      flippedY: Option[String],
      foreground: Option[String],
      hp: Option[String],
      sound: Option[String],
      sprite: Option[String],
      tile_id: Option[String]
  )

  val key = "breakable_block"
  implicit val jsonEncoder: Encoder[BreakableBlockNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[BreakableBlockNode] = deriveDecoder
}

final case class BreakableBlockNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int,
    override val rotation: Int,
    override val visible: Boolean,
    polygon: Option[Seq[util.IntPoint]],
    properties: BreakableBlockNode.Props
) extends Node(BreakableBlockNode.key) {
  override val actualName = if (name.isEmpty) { properties.sprite.getOrElse(throw new IllegalStateException(s"Unknown block [$id].")) } else { name }

  override val assets = Seq(
    Asset.Image(s"$t.$actualName", s"images/blocks/$actualName.png"),
    Asset.Audio(s"sfx.block_explode", s"audio/sfx/block_explode.ogg")
  ) ++ properties.sound.map(Asset.sfx)

  override def asNewGameObject = Seq(BreakableBlock(id = id, n = actualName, loc = asLocation, vis = visible))

  val polygonObj = polygon.map(points => Polygon(points.map(point => DoublePoint(point.x + x.toDouble, point.y + y.toDouble))))
}
