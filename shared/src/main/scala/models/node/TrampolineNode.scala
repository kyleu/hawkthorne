package models.node

import util.JsonSerializers._

object TrampolineNode {
  val key = "trampoline"
  implicit val jsonEncoder: Encoder[TrampolineNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[TrampolineNode] = deriveDecoder
}

case class TrampolineNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int
) extends Node(TrampolineNode.key)