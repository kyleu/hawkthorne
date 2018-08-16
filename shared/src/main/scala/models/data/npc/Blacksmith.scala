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
  talkItems = Seq[TalkItem]( /* TalkItem(prompt = "i am done with you", responses = Nil)
    TalkItem(prompt = "Anything happening here?", responses = Nil)
    TalkItem(prompt = "Any useful info for me?", responses = Nil) */ )
)
