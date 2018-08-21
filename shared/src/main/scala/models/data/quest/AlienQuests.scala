/* Generated File */
package models.data.quest

import models.template.quest.QuestTemplate

object AlienQuests {
  val alienObject = QuestTemplate(
    key = "alienObject",
    name = "Aliens! - Bring back alien technology from hostile aliens",
    source = "Alien",
    infinite = true,
    skipPrompt = false,
    successPrompt = Some("Earthling, would you like to have the honor of serving under me in {{teal}}my fight against the invading aliens?{{white}}"),
    promptExtra = Seq(
      "Good, good. Your first task is to {{blue_light}}hijack an item from a group of alien soldiers{{white}} camped up nearby.",
      "The aliens are camped up to the east of {{orange}}Tacotown{{white}}, on the way to the giant fence.",
      "I found out that one of the alien soldiers is carrying an alien technology that I need for my plan to bring them down.",
      "It's usually the blue {{blue_light}}Elite Alien{{white}} carrying important equipment, so target those guys first.",
      "I'll explain what I need the item for later. Be prepared for a fight, and try not to die eh?. Good luck then."
    ),
    giveQuestSucceed = Seq(
      "Alright, so listen up human. I need your help.",
      "There's a huge, hidden group of {{blue_light}}aliens{{white}} hiding in the Valley of Laziness, who are secretly preparing for an invasion.",
      "I was one of them, until I fell in love with Mexican food and decided to prevent those other aliens from destroying this fine cuisine.",
      "I ran away and hid myself in this farm, and ever since, I've been fighting against those other aliens. However, I can't do this by myself."
    ),
    completeQuestFail = Seq("The aliens are still camped up to the east of {{orange}}Tacotown{{white}}. I need the alien equipment that they're carrying!"),
    completeQuestSucceed = Seq(
      "Wow, impressive! You fought off all those aliens? You are tougher than you look.",
      "Okay, I have another task for you. Talk to me when you're ready."
    ),
    collect = Some(QuestTemplate.Collect(name = "alien_object2", t = "key")),
    reward = Some(QuestTemplate.Reward(affection = Some(1), money = None))
  )

  val alienCamp = QuestTemplate(
    key = "alienCamp",
    name = "Aliens! - Attack alien camp and bring back alien technology",
    source = "Alien",
    infinite = false,
    skipPrompt = false,
    successPrompt = Some("So, you ready for the next task?"),
    promptExtra = Seq(
      "So there's an even bigger group of aliens camped up by the {{orange}}Hills{{white}} area, who are in possession of another important alien equipment.",
      "I'm not gonna lie, this alien camp is stacked to the brim. It's gonna be extremely dangerous, so be prepared!",
      "It's the same drill as before. It's usually the {{blue_light}}Elite Alien{{white}} carrying important equipment, so target those guys first.",
      "Oh, you wanna know what I want to do with this alien technology? Well, that I'll tell you if you come back alive. Now go!"
    ),
    giveQuestSucceed = Seq("Ughhhh...the things I would do for a burrito right now--oh shoot, you're back already?"),
    completeQuestFail = Seq("The aliens are still camped up in the {{orange}}Hills{{white}} area. Chop chop!"),
    completeQuestSucceed = Seq("Ooh, I almost forgot to take with me the device you brought!"),
    collect = Some(QuestTemplate.Collect(name = "alien_object3", t = "key")),
    reward = Some(QuestTemplate.Reward(affection = Some(1), money = None))
  )

  val regroup = QuestTemplate(
    key = "regroup",
    name = "Aliens! - Regroup with the alien at Chili Fields",
    source = "Alien",
    infinite = false,
    skipPrompt = true,
    successPrompt = Some("Regroup in the {{red_light}}Chili Fields{{white}}!"),
    promptExtra = Nil,
    giveQuestSucceed = Seq(
      "Damn it, you stupid human! The aliens followed you back here! {{red_light}}We're under attack!{{white}}",
      "Survival first, come meet me at the {{red_light}}Chili Fields{{white}}, we gotta regroup!"
    ),
    completeQuestFail = Seq("What the hell are you still doing here? Go hold those aliens off!"),
    completeQuestSucceed = Nil,
    collect = None,
    reward = None
  )

  val qfo = QuestTemplate(
    key = "qfo",
    name = "Aliens! - Destroy the QFO!",
    source = "Alien",
    infinite = false,
    skipPrompt = false,
    successPrompt = Some("Do you want to take on the {{orange}}QFO{{white}}?"),
    promptExtra = Nil,
    giveQuestSucceed = Seq(""),
    completeQuestFail = Seq("What the hell are you still doing here? Go hold those aliens off!"),
    completeQuestSucceed = Seq(
      "You...you've done it! You've defeated the {{orange}}QFO{{white}}! Now I can eat Mexican food in peace, forever!",
      "As a token of thanks, you can have my standard issue {{blue_light}}alien pistol{{white}}, you'll need it more than I do. Here's some gold as well.",
      "Whenever you run out of ammo for the pistol come back to me and I will sell some to you.",
      "It was nice working with you partner. We've defeated them!"
    ),
    collect = None,
    reward = Some(QuestTemplate.Reward(affection = None, money = Some(150)))
  )

  val all = Seq(alienObject, alienCamp, regroup, qfo)
}
