package models.node

import util.JsonSerializers._

object SpawnNode {
  val key = "spawn"
  implicit val jsonEncoder: Encoder[SpawnNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[SpawnNode] = deriveDecoder
}

case class SpawnNode(
    override val x: Int,
    override val y: Int,
    override val width: Int = 0,
    override val height: Int = 0
) extends Node(SpawnNode.key, x, y, width, height)
