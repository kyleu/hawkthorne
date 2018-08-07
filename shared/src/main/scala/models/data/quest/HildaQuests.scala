/* Generated File */
package models.data.quest

import models.template.quest.QuestTemplate

object HildaQuests {
  val flowers = QuestTemplate(
    key = "flowers",
    name = "Collect Flowers for Hilda",
    infinite = true,
    successPrompt = Some("Do you want to collect flowers for {{red_light}}Hilda{{white}}?")
  )

  val all = Seq(flowers)
}
