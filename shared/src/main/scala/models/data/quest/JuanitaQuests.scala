/* Generated File */
package models.data.quest

import models.template.quest.QuestTemplate

object JuanitaQuests {
  val alcohol = QuestTemplate(
    key = "alcohol",
    name = "Help Juanita pick up empty bottles",
    infinite = true,
    skipPrompt = false,
    successPrompt = Some("Can you help me clean up by picking up some bottles?"),
    promptExtra = Nil,
    giveQuestSucceed = Seq(
      "Of course I am! Look at all this mess I have to clean up! It sucks being a cleaning person around these parts.",
      "You know, I am pretty darn sure that I'm the only one who does an honest day's work in this town."
    ),
    completeQuestFail = Seq("This place is filthy!"),
    completeQuestSucceed = Seq("Thanks for helping clean up! The town looks so much nicer!"),
    collect = Some(QuestTemplate.Collect(name = "alcohol", t = "consumable")),
    reward = Some(QuestTemplate.Reward(affection = Some(100), money = None))
  )

  val all = Seq(alcohol)
}
