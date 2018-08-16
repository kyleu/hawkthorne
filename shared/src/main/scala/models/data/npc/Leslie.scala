/* Generated File */
package models.data.npc

import models.animation.Animation
import models.npc.TalkItem
import models.template.npc.NpcTemplate

object Leslie extends NpcTemplate(
  key = "leslie",
  name = "Leslie",
  width = 48,
  height = 48,
  greeting = Some("I am {{red_light}}Leslie{{white}}, I travel around looking for interesting wares that I can sell."),
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(0, 1, 0, 0, 0, 0), delay = 0.5, loop = true)
  ),
  noInventory = None,
  noCommands = None,
  talkItems = Seq[TalkItem]( /* TalkItem(prompt = "i am done with you", responses = Nil)
    TalkItem(prompt = "Can I buy you a drink?", responses = Nil)
    TalkItem(prompt = "Any useful info for me?", responses = Nil) */ )
)
