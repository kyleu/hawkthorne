/* Generated File */
package models.data.quest

import models.template.quest.QuestTemplate

object LotusQuests {
  val boulders = QuestTemplate(
    key = "boulders",
    name = "Collect boulders for the Lotus Cult member",
    infinite = false,
    skipPrompt = false,
    successPrompt = Some("Do you want to collect boulders for {{red_light}}the Cult Member{{white}}?"),
    promptExtra = Nil,
    giveQuestSucceed = Seq(
      "I've been working on a new potion recently, but I'm missing a key ingredient.",
      "I need a {{teal}}boulder{{white}} to act as a reactant, but it looks like I'm all out!",
      "It would be great if you could bring some for me, I would of course reward you!"
    ),
    completeQuestFail = Seq("Have you collected any boulders yet? It can be created by combining two {{olive}}stones{{white}} together. Stones can be created by combining two {{teal}}rocks{{white}} together."),
    completeQuestSucceed = Seq("Thank you so much! I can finish my potion now!"),
    collect = Some(QuestTemplate.Collect(name = "boulder", t = "material")),
    reward = Some(QuestTemplate.Reward(affection = Some(300), money = None))
  )

  val all = Seq(boulders)
}
