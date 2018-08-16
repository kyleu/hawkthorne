/* Generated File */
package models.data.npc

import models.animation.Animation
import models.npc.TalkItem
import models.template.npc.NpcTemplate

object LaserLotus1 extends NpcTemplate(
  key = "laserlotus1",
  name = "LaserLotus1",
  width = 24,
  height = 48,
  greeting = None,
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 3, 4), delay = 0.25, loop = true),
    Animation(id = "walking", frames = IndexedSeq(0, 1, 2), delay = 0.2, loop = true)
  ),
  noInventory = None,
  noCommands = Some("I only take commands from a laser lotus above level 7 or the Great Buddha himself!"),
  talkItems = Seq[TalkItem]( /* TalkItem(prompt = "i am done with you", responses = Nil)
    TalkItem(prompt = "Who are you?", responses = Nil)
    TalkItem(prompt = "What cult is this?", responses = Nil)
    TalkItem(prompt = "Why are you in a cave?", responses = Nil) */ )
)
