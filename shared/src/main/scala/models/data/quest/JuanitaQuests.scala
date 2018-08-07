/* Generated File */
package models.data.quest

import models.template.quest.QuestTemplate

object JuanitaQuests {
  val alcohol = QuestTemplate(
    key = "alcohol",
    name = "Help Juanita pick up empty bottles",
    infinite = true,
    successPrompt = Some("Can you help me clean up by picking up some bottles?")
  )

  val all = Seq(alcohol)
}
