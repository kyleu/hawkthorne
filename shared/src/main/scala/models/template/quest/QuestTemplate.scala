package models.template.quest

import util.JsonSerializers._

object QuestTemplate {
  implicit val jsonEncoder: Encoder[QuestTemplate] = deriveEncoder
  implicit val jsonDecoder: Decoder[QuestTemplate] = deriveDecoder
}

case class QuestTemplate(
    key: String,
    name: String,
    infinite: Boolean,
    successPrompt: Option[String]
) {
  lazy val json = {
    this.asJson.spaces2
  }
}
