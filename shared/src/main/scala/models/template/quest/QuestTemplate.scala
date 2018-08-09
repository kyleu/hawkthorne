package models.template.quest

import util.JsonSerializers._

object QuestTemplate {
  object Reward {
    implicit val jsonEncoder: Encoder[Reward] = deriveEncoder
    implicit val jsonDecoder: Decoder[Reward] = deriveDecoder
  }

  case class Reward(affection: Option[Int], money: Option[Int])

  object Collect {
    implicit val jsonEncoder: Encoder[Collect] = deriveEncoder
    implicit val jsonDecoder: Decoder[Collect] = deriveDecoder
  }

  case class Collect(name: String, t: String)

  implicit val jsonEncoder: Encoder[QuestTemplate] = deriveEncoder
  implicit val jsonDecoder: Decoder[QuestTemplate] = deriveDecoder
}

case class QuestTemplate(
    key: String,
    name: String,
    infinite: Boolean,
    skipPrompt: Boolean,
    successPrompt: Option[String],
    promptExtra: Seq[String],
    giveQuestSucceed: Seq[String],
    completeQuestFail: Seq[String],
    completeQuestSucceed: Seq[String],
    collect: Option[QuestTemplate.Collect],
    reward: Option[QuestTemplate.Reward]
) {
  lazy val json = {
    this.asJson.spaces2
  }
}
