/* Generated File */
package models.data.npc

import models.animation.Animation
import models.npc.TalkItem
import models.template.npc.NpcTemplate

object ProfHolly extends NpcTemplate(
  key = "profholly",
  name = "ProfHolly",
  width = 32,
  height = 48,
  greeting = Some("Hello, my precious blueberry! You can call me {{red_light}}Professor Holly{{white}}."),
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(0, 10), delay = 0.5, loop = true),
    Animation(id = "walking", frames = IndexedSeq(0, 1, 2), delay = 0.2, loop = true)
  ),
  noInventory = Some("Sorry, blueberry. All I have is on the shelves!"),
  noCommands = Some("Command is such a strong, ugly word."),
  talkItems = Seq[TalkItem](
    TalkItem(prompt = "I am done with you", responses = Nil),
    TalkItem(prompt = "No Ghosting, huh?", responses = Nil, children = Seq(
      TalkItem(prompt = "A long lonely tiiiiime", responses = List("(Professor Holly grinds his teeth.)")),
      TalkItem(prompt = "Hungered for your touch", responses = List("(Professor Holly's right eye twitches slightly.)")),
      TalkItem(prompt = "My darling...", responses = List("(Professor Holly lets out a pained whimper.)")),
      TalkItem(prompt = "Oh, my love...", responses = List("(Professor Holly crushes the lump of clay in his hands. Hard.)"))
    )),
    TalkItem(prompt = "How to get an art credit.", responses = List("Participation! You've just passed by being here!", "Congratulations, little blueberry!")),
    TalkItem(prompt = "Hello, professor.", responses = List("Hello, my precious blueberry!", "I hope you've been having a fantastic adventure."))
  )
)
