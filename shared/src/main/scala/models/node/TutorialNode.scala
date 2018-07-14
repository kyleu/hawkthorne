package models.node

import util.JsonSerializers._

object TutorialNode {
  val key = "tutorial"
  implicit val jsonEncoder: Encoder[TutorialNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[TutorialNode] = deriveDecoder
}

case class TutorialNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int
) extends Node(TutorialNode.key)
