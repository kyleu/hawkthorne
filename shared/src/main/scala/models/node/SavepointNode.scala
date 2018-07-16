package models.node

import util.JsonSerializers._

object SavepointNode {
  val key = "savepoint"
  implicit val jsonEncoder: Encoder[SavepointNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[SavepointNode] = deriveDecoder
}

case class SavepointNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int,
    override val rotation: Option[Int],
    override val visible: Option[Boolean]
) extends Node(SavepointNode.key)
