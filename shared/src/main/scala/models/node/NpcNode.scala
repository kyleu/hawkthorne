package models.node

import util.JsonSerializers._

object NpcNode {
  val key = "npc"
  implicit val jsonEncoder: Encoder[NpcNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[NpcNode] = deriveDecoder
}

case class NpcNode(
    override val x: Int,
    override val y: Int,
    override val width: Int = 0,
    override val height: Int = 0
) extends Node(NpcNode.key, x, y, width, height)
