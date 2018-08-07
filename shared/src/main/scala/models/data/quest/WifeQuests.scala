/* Generated File */
package models.data.quest

import models.template.quest.QuestTemplate

object WifeQuests {
  val mushroom = QuestTemplate(
    key = "mushroom",
    name = "Remove invasive mushrooms in the treetops",
    infinite = false,
    successPrompt = Some("Could you go remove ALL of those {{blue_light}} mushrooms{{white}} on the treetops? I will pay you handsomely!")
  )

  val all = Seq(mushroom)
}
