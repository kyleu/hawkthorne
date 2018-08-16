package models.npc

import util.JsonSerializers._

object TalkItem {
  implicit val jsonEncoder: Encoder[TalkItem] = deriveEncoder
  implicit val jsonDecoder: Decoder[TalkItem] = deriveDecoder
}

case class TalkItem(prompt: String, responses: Seq[String], children: Seq[TalkItem] = Nil)
