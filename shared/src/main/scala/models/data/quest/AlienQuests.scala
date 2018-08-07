/* Generated File */
package models.data.quest

import models.template.quest.QuestTemplate

object AlienQuests {
  val alienObject = QuestTemplate(
    key = "alienObject",
    name = "Aliens! - Bring back alien technology from hostile aliens",
    infinite = true,
    successPrompt = Some("Earthling, would you like to have the honor of serving under me in {{teal}}my fight against the invading aliens?{{white}}")
  )

  val alienCamp = QuestTemplate(
    key = "alienCamp",
    name = "Aliens! - Attack alien camp and bring back alien technology",
    infinite = false,
    successPrompt = Some("So, you ready for the next task?")
  )

  val regroup = QuestTemplate(
    key = "regroup",
    name = "Aliens! - Regroup with the alien at Chili Fields",
    infinite = false,
    successPrompt = Some("Regroup in the {{red_light}}Chili Fields{{white}}!")
  )

  val qfo = QuestTemplate(
    key = "qfo",
    name = "Aliens! - Destroy the QFO!",
    infinite = false,
    successPrompt = Some("Do you want to take on the {{orange}}QFO{{white}}?")
  )

  val all = Seq(alienObject, alienCamp, regroup, qfo)
}
