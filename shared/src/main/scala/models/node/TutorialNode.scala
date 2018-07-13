package models.node

import util.JsonSerializers._

object TutorialNode {
  val key = "tutorial"
  implicit val jsonEncoder: Encoder[TutorialNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[TutorialNode] = deriveDecoder
}

case class TutorialNode(
    override val x: Int,
    override val y: Int,
    override val width: Int = 0,
    override val height: Int = 0
) extends Node(TutorialNode.key, x, y, width, height)
