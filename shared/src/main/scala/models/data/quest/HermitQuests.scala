/* Generated File */
package models.data.quest

import models.template.quest.QuestTemplate

object HermitQuests {
  val berry = QuestTemplate(
    key = "berry",
    name = "To Slay An Acorn - Collect the Special Berry",
    infinite = true,
    skipPrompt = false,
    successPrompt = Some("Do you want to collect the {{red_dark}}berry{{white}}?"),
    promptExtra = Nil,
    giveQuestSucceed = Seq(
      "I know why you are here adventurer, you are seeking my advice on how to defeat the Acorn King.",
      "You think you'd go unnoticed while you stomped around the mountain? I've heard about you and your quest, adventurer.",
      "Fear not, I am on your side. I can tell you exactly where you can find the Acorn King.",
      "He lives in a magically protected hideout in the mountains, but it's unreachable by foot. You're going to need a {{orange}}special potion{{white}}.",
      "The potion will, uh--transform you into a, uh--nature spirit thus allowing you to bypass his enchantments--yea.",
      "I have all but one of the ingredients required to make that potion. If you bring me that last ingredient, I will make you the potion.",
      "It is a special {{red_dark}}berry{{white}} that only grows up in Acornspeak, and it is crucial in brewing this potion.",
      "Come back when you have collected the {{red_dark}}berry{{white}}, I only need one of them. The rope beside me will take you down from Stonerspeak."
    ),
    completeQuestFail = Seq("Haven't gotten those berries yet? They grow up in Acornpeak, you need to collect one for me to make your potion."),
    completeQuestSucceed = Seq("Your quest ends here for now..."),
    collect = Some(QuestTemplate.Collect(name = "berry", t = "material")),
    reward = Some(QuestTemplate.Reward(affection = None, money = None))
  )

  val all = Seq(berry)
}
