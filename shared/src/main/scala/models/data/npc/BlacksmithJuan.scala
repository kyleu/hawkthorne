/* Generated File */
package models.data.npc

import models.animation.Animation
import models.npc.TalkItem
import models.template.npc.NpcTemplate

object BlacksmithJuan extends NpcTemplate(
  key = "blacksmithjuan",
  name = "BlacksmithJuan",
  width = 48,
  height = 48,
  greeting = None,
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(0, 1), delay = 0.2, loop = true)
  ),
  noInventory = None,
  noCommands = None,
  talkItems = Seq[TalkItem]( /* TalkItem(prompt = "i am done with you", responses = Nil)
    TalkItem(prompt = "What are you drinking?", responses = Nil)
    TalkItem(prompt = "Any useful info for me?", responses = Nil) */ )
)
