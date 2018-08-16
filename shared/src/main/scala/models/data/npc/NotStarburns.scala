/* Generated File */
package models.data.npc

import models.animation.Animation
import models.npc.TalkItem
import models.template.npc.NpcTemplate

object NotStarburns extends NpcTemplate(
  key = "notstarburns",
  name = "NotStarburns",
  width = 24,
  height = 15,
  greeting = None,
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(0, 1, 2, 0, 0, 0), delay = 0.5, loop = true)
  ),
  noInventory = None,
  noCommands = None,
  talkItems = Seq[TalkItem]( /* TalkItem(prompt = "i am done with you", responses = Nil)
    TalkItem(prompt = "Do I smell...meth?", responses = Nil)
    TalkItem(prompt = "Star Burns?", responses = Nil) */ )
)
