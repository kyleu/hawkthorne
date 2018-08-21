/* Generated File */
package models.data.quest

import models.template.quest.QuestTemplate

object HildaQuests {
  val flowers = QuestTemplate(
    key = "flowers",
    name = "Collect Flowers for Hilda",
    source = "Hilda",
    infinite = true,
    skipPrompt = false,
    successPrompt = Some("Do you want to collect flowers for {{red_light}}Hilda{{white}}?"),
    promptExtra = Nil,
    giveQuestSucceed = Seq(
      "I love {{teal}}flowers{{white}}!",
      "I used to collect {{teal}}flowers{{white}} from the {{olive}}forest{{white}} beyond the {{green_light}}blacksmith{{white}} but ever since {{grey}}Hawkthorne{{white}} started ruling the {{olive}}forests{{white}} haven't been safe.",
      "I would be so happy if someone could pick me some!"
    ),
    completeQuestFail = Seq("Have you found any flowers? Try looking beyond the town."),
    completeQuestSucceed = Seq("My goodness, these flowers are beautiful! Thank you so very much!"),
    collect = Some(QuestTemplate.Collect(name = "flowers", t = "material")),
    reward = Some(QuestTemplate.Reward(affection = Some(300), money = None))
  )

  val all = Seq(flowers)
}
