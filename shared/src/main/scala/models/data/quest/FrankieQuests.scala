/* Generated File */
package models.data.quest

import models.template.quest.QuestTemplate

object FrankieQuests {
  val potatoes = QuestTemplate(
    key = "potatoes",
    name = "Save Greendale - Collect potatoes",
    infinite = true,
    successPrompt = Some("Alright let's see...if you bring me a {{olive}}potato{{white}}, I'll give you 50 coins. How does that sound?")
  )

  val bones = QuestTemplate(
    key = "bones",
    name = "Save Greendale - Remove bones from parking lot",
    infinite = false,
    successPrompt = Some("Can you remove the bones from the parking lot?")
  )

  val peanutCostume = QuestTemplate(
    key = "peanutCostume",
    name = "Save Greendale - Find peanut bar costume receipt",
    infinite = false,
    successPrompt = Some("Can you go retrieve the receipt for Dean's stupid costume?")
  )

  val officeKey = QuestTemplate(
    key = "officeKey",
    name = "Save Greendale - Look for the lost office key",
    infinite = false,
    successPrompt = Some("Can you go look for the lost key? It should still be on campus somewhere.")
  )

  val pool = QuestTemplate(
    key = "pool",
    name = "Save Greendale - Find out what the delay with pool repairs is",
    infinite = false,
    successPrompt = Some("Could you go find out what the delay is?")
  )

  val poolReturn = QuestTemplate(
    key = "poolReturn",
    name = "Save Greendale - Return back to Frankie",
    infinite = false,
    successPrompt = Some("Can you tell Ms. Dart that we will have the pool open soon?")
  )

  val dianeEmail = QuestTemplate(
    key = "dianeEmail",
    name = "Save Greendale - Mail Diane",
    infinite = false,
    successPrompt = Some("Could you deposit this document into the mailbox? And no montages!")
  )

  val dianeReturn = QuestTemplate(
    key = "dianeReturn",
    name = "Save Greendale - Return to Frankie",
    infinite = false,
    successPrompt = None
  )

  val all = Seq(potatoes, bones, peanutCostume, officeKey, pool, poolReturn, dianeEmail, dianeReturn)
}
