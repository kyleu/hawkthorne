/* Generated File */
package models.data.npc

import models.animation.Animation
import models.npc.TalkItem
import models.template.npc.NpcTemplate

object AlienRegroup extends NpcTemplate(
  key = "alien_regroup",
  name = "AlienRegroup",
  width = 29,
  height = 48,
  greeting = None,
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(1), delay = 0.5, loop = true),
    Animation(id = "walking", frames = IndexedSeq(7, 8, 9), delay = 0.2, loop = true)
  ),
  noInventory = Some("Calm down there human, I'll sell you my supplies when I get back to my cave."),
  noCommands = None,
  talkItems = Seq[TalkItem]( /* TalkItem(prompt = "i am done with you", responses = Nil)
    TalkItem(prompt = "You are a dick.", responses = Nil)
    TalkItem(prompt = "Aliens are everywhere!", responses = Nil) */ )
)
