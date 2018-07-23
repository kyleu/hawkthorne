package models.node

import models.asset.Asset
import util.JsonSerializers._

object SparkleNode {
  val key = "sparkle"
  implicit val jsonEncoder: Encoder[SparkleNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[SparkleNode] = deriveDecoder
}

final case class SparkleNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int,
    override val rotation: Int,
    override val visible: Boolean
) extends Node(SparkleNode.key) {
  override val assets = Seq(Asset.Spritesheet(s"cornelius.sparkle", s"images/cutscenes/cornelius_sparkles.png", actualWidth, actualHeight))
}
