package models.node

import util.JsonSerializers._

object MailboxNode {
  val key = "mailbox"
  implicit val jsonEncoder: Encoder[MailboxNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[MailboxNode] = deriveDecoder
}

case class MailboxNode(
    override val x: Int,
    override val y: Int,
    override val width: Int = 0,
    override val height: Int = 0
) extends Node(MailboxNode.key, x, y, width, height)
