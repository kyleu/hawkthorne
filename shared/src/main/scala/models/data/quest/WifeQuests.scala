/* Generated File */
package models.data.quest

import models.template.quest.QuestTemplate

object WifeQuests {
  val mushroom = QuestTemplate(
    key = "mushroom",
    name = "Remove invasive mushrooms in the treetops",
    infinite = false,
    skipPrompt = false,
    successPrompt = Some("Could you go remove ALL of those {{blue_light}} mushrooms{{white}} on the treetops? I will pay you handsomely!"),
    promptExtra = Nil,
    giveQuestSucceed = Seq(
      "Adventurer! If you had time, I was wondering if you could help me out with a small problem?",
      "Just on the other side of the mountains on the way to {{orange}}Valley of Laziness{{white}}, there's a hidden door leading to the treetops.",
      "Recently, an invasive species of {{blue_light}}blue mushrooms{{white}} have begun growing there, threatening local plants!"
    ),
    completeQuestFail = Seq("The {{blue_light}}blue mushrooms{{white}} are in the treetops, on the way to {{orange}}Valley of Laziness{{white}}! Please remove them for me!"),
    completeQuestSucceed = Seq("Thank you for removing those mushrooms! You can probably sell those in shops in {{orange}}Valley of Laziness{{white}}."),
    collect = None,
    reward = Some(QuestTemplate.Reward(affection = None, money = Some(300)))
  )

  val all = Seq(mushroom)
}
