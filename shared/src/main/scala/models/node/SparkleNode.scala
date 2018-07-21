package models.node

import util.JsonSerializers._

object SparkleNode {
  val key = "sparkle"
  implicit val jsonEncoder: Encoder[SparkleNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[SparkleNode] = deriveDecoder
}

case class SparkleNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int,
    override val rotation: Int,
    override val visible: Boolean
) extends Node(SparkleNode.key)
