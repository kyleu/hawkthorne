/* Generated File */
package models.data.quest

import models.template.quest.QuestTemplate

object TelescopeJuanQuests {
  val alien = QuestTemplate(
    key = "alien",
    name = "Aliens! - Investigate Goat Farm",
    infinite = false,
    successPrompt = Some("Can you go {{red_light}}investigate the goat farm and retrieve whatever alien object is there?{{white}}")
  )

  val all = Seq(alien)
}
