/* Generated File */
package models.data.quest

import models.template.quest.QuestTemplate

object TelescopeJuanQuests {
  val alien = QuestTemplate(
    key = "alien",
    name = "Aliens! - Investigate Goat Farm",
    source = "TelescopeJuan",
    infinite = false,
    skipPrompt = false,
    successPrompt = Some("Can you go {{red_light}}investigate the goat farm and retrieve whatever alien object is there?{{white}}"),
    promptExtra = Seq(
      "Excellent! But first, you're gonna need a key to get inside the farm.",
      "Talk to Juan with the {{purple}}purple sombrero{{white}}, he owns the goat farm. Maybe you can persuade him to let you in."
    ),
    giveQuestSucceed = Seq(
      "You will not believe what's been going on lately!",
      "Animals have recently been disappearing in the area and I've been seeing these weird alien lights at night!",
      "Just last night, I saw a bright object fall out of the sky into the goat farm nearby. {{teal}}Aliens, aliens!{{white}}"
    ),
    completeQuestFail = Seq("The entrance to the goat farm is right beside Juan with the {{purple}}purple sombrero{{white}}. Ask him for the key to get inside!"),
    completeQuestSucceed = Seq(
      "Ooh, this alien thing looks amazing. This is definite proof that aliens are among us!",
      "Here's some money for your troubles, thanks again!"
    ),
    collect = Some(QuestTemplate.Collect(name = "alien_object", t = "key")),
    reward = Some(QuestTemplate.Reward(affection = None, money = Some(70)))
  )

  val all = Seq(alien)
}
