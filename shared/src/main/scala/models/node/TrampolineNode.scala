package models.node

import util.JsonSerializers._

object TrampolineNode {
  val key = "trampoline"
  implicit val jsonEncoder: Encoder[TrampolineNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[TrampolineNode] = deriveDecoder
}

case class TrampolineNode(
    override val x: Int,
    override val y: Int,
    override val width: Int = 0,
    override val height: Int = 0
) extends Node(TrampolineNode.key, x, y, width, height)
