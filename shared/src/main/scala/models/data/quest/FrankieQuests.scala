/* Generated File */
package models.data.quest

import models.template.quest.QuestTemplate

object FrankieQuests {
  val potatoes = QuestTemplate(
    key = "potatoes",
    name = "Save Greendale - Collect potatoes",
    infinite = true,
    skipPrompt = false,
    successPrompt = Some("Alright let's see...if you bring me a {{olive}}potato{{white}}, I'll give you 50 coins. How does that sound?"),
    promptExtra = Nil,
    giveQuestSucceed = Seq("Someone's been leaving {{olive}}potatoes{{white}} on our rooftops as a weird prank of some sorts."),
    completeQuestFail = Seq("Found those {{olive}}potatoes{{white}} yet? They're still on the roofs I hear."),
    completeQuestSucceed = Seq("Thank you for getting rid of those potatoes!"),
    collect = Some(QuestTemplate.Collect(name = "potato", t = "material")),
    reward = Some(QuestTemplate.Reward(affection = Some(50), money = Some(50)))
  )

  val bones = QuestTemplate(
    key = "bones",
    name = "Save Greendale - Remove bones from parking lot",
    infinite = false,
    skipPrompt = false,
    successPrompt = Some("Can you remove the bones from the parking lot?"),
    promptExtra = Nil,
    giveQuestSucceed = Seq(
      "The janitorial staff reported that the school parking lot is currently littered with bones of unknown origins.",
      "I do not care nor do I want to find out where those bones came from, but we need to clean them up."
    ),
    completeQuestFail = Seq("The parking lot is still littered with those creepy bones!"),
    completeQuestSucceed = Seq("Thank you for helping clean up the parking lot! Even for Greendale, that was creepy."),
    collect = None,
    reward = Some(QuestTemplate.Reward(affection = Some(100), money = None))
  )

  val peanutCostume = QuestTemplate(
    key = "peanutCostume",
    name = "Save Greendale - Find peanut bar costume receipt",
    infinite = false,
    skipPrompt = false,
    successPrompt = Some("Can you go retrieve the receipt for Dean's stupid costume?"),
    promptExtra = Nil,
    giveQuestSucceed = Seq(
      "So I have discovered that the Dean used school expenses to purchase an exorbitantly priced peanut bar costume.",
      "I'm hoping to find the receipt for the costume so I can get a refund before it's too late.",
      "The receipt should be lying around somewhere in the Dean's closet, I need someone to go find it."
    ),
    completeQuestFail = Seq("Have you found the receipt yet? It should be somewhere inside the Dean's closet."),
    completeQuestSucceed = Seq("Thank you for retrieving the receipt! Hopefully it's not too late to get our money back..."),
    collect = Some(QuestTemplate.Collect(name = "receipt", t = "key")),
    reward = Some(QuestTemplate.Reward(affection = Some(200), money = None))
  )

  val officeKey = QuestTemplate(
    key = "officeKey",
    name = "Save Greendale - Look for the lost office key",
    infinite = false,
    skipPrompt = false,
    successPrompt = Some("Can you go look for the lost key? It should still be on campus somewhere."),
    promptExtra = Nil,
    giveQuestSucceed = Seq(
      "Last night, the Dean lost the spare office key in the Administration building while stalking a certain Mr. Winger.",
      "Sometimes, I wonder which buffoon put the Dean in charge."
    ),
    completeQuestFail = Seq("Have you found the key yet? It should hopefully still be on campus somewhere."),
    completeQuestSucceed = Seq("Thank you for retrieving the key!"),
    collect = Some(QuestTemplate.Collect(name = "office_key", t = "key")),
    reward = Some(QuestTemplate.Reward(affection = Some(140), money = None))
  )

  val pool = QuestTemplate(
    key = "pool",
    name = "Save Greendale - Find out what the delay with pool repairs is",
    infinite = false,
    skipPrompt = false,
    successPrompt = Some("Could you go find out what the delay is?"),
    promptExtra = Nil,
    giveQuestSucceed = Seq("The Borchert Hall pool has been closed for weeks for repairs, but there seems to be no progress being made!"),
    completeQuestFail = Seq("Please go find out what is taking so long with the pool repairs!"),
    completeQuestSucceed = Seq("Thank you for getting the repair guys back to work again! Hopefully the pool should be back up and running."),
    collect = None,
    reward = None
  )

  val poolReturn = QuestTemplate(
    key = "poolReturn",
    name = "Save Greendale - Return back to Frankie",
    infinite = false,
    skipPrompt = false,
    successPrompt = Some("Can you tell Ms. Dart that we will have the pool open soon?"),
    promptExtra = Nil,
    giveQuestSucceed = Seq("Oh geez, you actually went ahead and found my wrench and wires...alright fine I guess we'll do some work or something..."),
    completeQuestFail = Seq(
      "Well, the pool is actually somehow electrified at the moment. We'd fix it, but we're running low on some supplies.",
      "We need a {{orange}}wrench{{white}} and some {{orange}}wires{{white}} to make the repairs, but we got nothing in this damn school.",
      "I remember I lost a wrench working in the Health Center vents some time ago, and there may be some spare wires in the Classroom buildings basement.",
      "Of course, we don't get paid enough to actually go looking for those materials, so here we are, sitting around for the electricity to run out."
    ),
    completeQuestSucceed = Seq("Thank you for getting the repair guys back to work again! Hopefully the pool should be back up and running."),
    collect = None,
    reward = Some(QuestTemplate.Reward(affection = Some(200), money = Some(50)))
  )

  val dianeEmail = QuestTemplate(
    key = "dianeEmail",
    name = "Save Greendale - Mail Diane",
    infinite = false,
    skipPrompt = false,
    successPrompt = Some("Could you deposit this document into the mailbox? And no montages!"),
    promptExtra = Nil,
    giveQuestSucceed = Seq(
      "I have an important document that I need to send to a certain Diane.",
      "I would send an e-mail, but there is some trouble with campus wi-fi and the IT lady is nowhere to be seen."
    ),
    completeQuestFail = Seq("Have you deposited it into the mailbox yet? The mailbox is at the west end of the campus. And no wasting time with montages!"),
    completeQuestSucceed = Nil,
    collect = Some(QuestTemplate.Collect(name = "office_key", t = "key")),
    reward = None
  )

  val dianeReturn = QuestTemplate(
    key = "dianeReturn",
    name = "Save Greendale - Return to Frankie",
    infinite = false,
    skipPrompt = false,
    successPrompt = None,
    promptExtra = Nil,
    giveQuestSucceed = Nil,
    completeQuestFail = Nil,
    completeQuestSucceed = Seq("Thank you for depositing the mail!"),
    collect = None,
    reward = Some(QuestTemplate.Reward(affection = Some(50), money = None))
  )

  val all = Seq(potatoes, bones, peanutCostume, officeKey, pool, poolReturn, dianeEmail, dianeReturn)
}
