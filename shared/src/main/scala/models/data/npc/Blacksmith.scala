/* Generated File */
package models.data.npc

import models.animation.Animation
import models.npc.TalkItem
import models.template.npc.NpcTemplate

object Blacksmith extends NpcTemplate(
  key = "blacksmith",
  name = "Blacksmith",
  width = 63,
  height = 66,
  greeting = None,
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(0, 1, 2, 3), delay = 0.2, loop = true),
    Animation(id = "talking", frames = IndexedSeq(4, 1, 6, 3), delay = 0.2, loop = true),
    Animation(id = "hurt", frames = IndexedSeq(16, 17, 18, 19), delay = 0.2, loop = true),
    Animation(id = "dying", frames = IndexedSeq(15, 16, 17, 16, 15), delay = 0.15, loop = false),
    Animation(id = "yelling", frames = IndexedSeq(11, 14), delay = 0.2, loop = true)
  ),
  noInventory = None,
  noCommands = None,
  talkItems = Seq[TalkItem](
    TalkItem(prompt = "I am done with you", responses = Nil),
    TalkItem(prompt = "Anything happening here?", responses = List("We used to have a cult leader that claimed to specialize in alchemy stay in the house next door.", "What was odd was that he left with nothing and there was no alchemy equipment in the house at all.", "We think that he was just lying in an attempt to obtain followers.")),
    TalkItem(prompt = "Any useful info for me?", responses = List("You will need some weapons and potions if you are going to survive.")),
    TalkItem(prompt = "Hello!", responses = List("Hello, I am the blacksmith.", "You may have met my lovely daughter, Hilda."))
  )
)
