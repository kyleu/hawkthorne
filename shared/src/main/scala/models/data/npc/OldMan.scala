/* Generated File */
package models.data.npc

import models.animation.Animation
import models.npc.TalkItem
import models.template.npc.NpcTemplate

object OldMan extends NpcTemplate(
  key = "oldman",
  name = "OldMan",
  width = 32,
  height = 32,
  greeting = Some("Bah! Go away."),
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(8), delay = 0.5, loop = true),
    Animation(id = "walking", frames = IndexedSeq(0, 1, 2, 3, 4, 5, 6, 7, 8), delay = 0.1, loop = true)
  ),
  noInventory = None,
  noCommands = None,
  talkItems = Seq[TalkItem]( /* TalkItem(prompt = "i am done with you", responses = Nil)
    TalkItem(prompt = "Any useful info for me?", responses = Nil)
    TalkItem(prompt = "This town is in ruins!", responses = Nil) */ )
)
