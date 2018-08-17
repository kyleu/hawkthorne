/* Generated File */
package models.data.npc

import models.animation.Animation
import models.npc.TalkItem
import models.template.npc.NpcTemplate

object Alien extends NpcTemplate(
  key = "alien",
  name = "Alien",
  width = 29,
  height = 48,
  greeting = Some("An adventurer! You might just be what I need..."),
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(1), delay = 0.5, loop = true),
    Animation(id = "walking", frames = IndexedSeq(7, 8, 9), delay = 0.2, loop = true)
  ),
  noInventory = None,
  noCommands = None,
  talkItems = Seq[TalkItem](
    TalkItem(prompt = "I am done with you", responses = Nil),
    TalkItem(prompt = "Who are you?", responses = List("My name is {{green_light}}Juan{{white}}, an alien from another planet.", "I've fallen in love with the Mexican food on this planet, so I've changed my name and decided to live among you.")),
    TalkItem(prompt = "What do you do here?", responses = List("Shhh, I'm hiding here from my other alien brethren!", "If they find me, they'll kill me and make sure I never taste another burrito again...oh, the horror!")),
    TalkItem(prompt = "Talk about quests", responses = Nil)
  )
)
