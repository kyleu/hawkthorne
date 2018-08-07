/* Generated File */
package models.data.quest

import models.template.quest.QuestTemplate

object LotusQuests {
  val boulders = QuestTemplate(
    key = "boulders",
    name = "Collect boulders for the Lotus Cult member",
    infinite = false,
    successPrompt = Some("Do you want to collect boulders for {{red_light}}the Cult Member{{white}}?")
  )

  val all = Seq(boulders)
}
