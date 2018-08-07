/* Generated File */
package models.data.quest

import models.template.quest.QuestTemplate

object HermitQuests {
  val berry = QuestTemplate(
    key = "berry",
    name = "To Slay An Acorn - Collect the Special Berry",
    infinite = true,
    successPrompt = Some("Do you want to collect the {{red_dark}}berry{{white}}?")
  )

  val all = Seq(berry)
}
