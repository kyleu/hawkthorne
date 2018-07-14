package models.node

import util.JsonSerializers._

object SpawnNode {
  val key = "spawn"
  implicit val jsonEncoder: Encoder[SpawnNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[SpawnNode] = deriveDecoder
}

case class SpawnNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int
) extends Node(SpawnNode.key)
