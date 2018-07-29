package models.node

import models.asset.Asset
import util.JsonSerializers._

object SparkleNode {
  val key = "sparkle"
  val asset = Asset.Spritesheet(s"cornelius.sparkle", s"images/cutscenes/cornelius_sparkles.png", 24, 24)

  implicit val jsonEncoder: Encoder[SparkleNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[SparkleNode] = deriveDecoder
}

final case class SparkleNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int = 24,
    override val height: Int = 24,
    override val rotation: Int = 0,
    override val visible: Boolean = true
) extends Node(SparkleNode.key) {
  override val assets = Seq(SparkleNode.asset)
}
