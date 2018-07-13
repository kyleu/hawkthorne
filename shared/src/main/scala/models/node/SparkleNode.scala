package models.node

import util.JsonSerializers._

object SparkleNode {
  val key = "sparkle"
  implicit val jsonEncoder: Encoder[SparkleNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[SparkleNode] = deriveDecoder
}

case class SparkleNode(
    override val x: Int,
    override val y: Int,
    override val width: Int = 0,
    override val height: Int = 0
) extends Node(SparkleNode.key, x, y, width, height)
