package models.node

import util.JsonSerializers._

object EnemyNode {
  val key = "enemy"
  implicit val jsonEncoder: Encoder[EnemyNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[EnemyNode] = deriveDecoder
}

case class EnemyNode(
    override val x: Int,
    override val y: Int,
    override val width: Int = 0,
    override val height: Int = 0
) extends Node(EnemyNode.key, x, y, width, height)
