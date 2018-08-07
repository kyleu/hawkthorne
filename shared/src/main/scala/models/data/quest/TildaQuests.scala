/* Generated File */
package models.data.quest

import models.template.quest.QuestTemplate

object TildaQuests {
  val slayAcorn = QuestTemplate(
    key = "slayAcorn",
    name = "To Slay An Acorn - Ask Around the Village about the Acorn King",
    infinite = false,
    successPrompt = Some("Will you not help me?")
  )

  val exploreMines = QuestTemplate(
    key = "exploreMines",
    name = "To Slay An Acorn - Explore the Mines for a Map to the Acorn King",
    infinite = false,
    successPrompt = Some("You say the Acorn King plans on destroying this town?")
  )

  val findHermit = QuestTemplate(
    key = "findHermit",
    name = "To Slay an Acorn - Find the Old Hermit at Stonerspeak",
    infinite = false,
    successPrompt = Some("The map is gone?!?")
  )

  val collectBerries = QuestTemplate(
    key = "collectBerries",
    name = "To Slay An Acorn - Collect the Special Berry for the Hermit",
    infinite = false,
    successPrompt = None
  )

  val all = Seq(slayAcorn, exploreMines, findHermit, collectBerries)
}
