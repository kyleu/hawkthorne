/* Generated File */
package models.data.npc

import models.animation.Animation
import models.npc.TalkItem
import models.template.npc.NpcTemplate

object TownKnight extends NpcTemplate(
  key = "townknight",
  name = "TownKnight",
  width = 70,
  height = 55,
  greeting = Some("My name is {{red_light}}Sir Merek{{white}}, I became a knight to protect this {{olive}}village{{white}} from the dangers of the forest."),
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(0), delay = 0.5, loop = true),
    Animation(id = "walking", frames = IndexedSeq(0, 1, 2, 3), delay = 0.2, loop = true),
    Animation(id = "draw_sword", frames = IndexedSeq(4, 5, 6, 7, 8, 9), delay = 0.2, loop = false),
    Animation(id = "attack", frames = IndexedSeq(10, 11), delay = 0.2, loop = true)
  ),
  noInventory = None,
  noCommands = None,
  talkItems = Seq[TalkItem]( /* TalkItem(prompt = "i am done with you", responses = Nil)
    TalkItem(prompt = "Any useful info for me?", responses = Nil)
    TalkItem(prompt = "This town is in ruins!", responses = Nil) */ )
)
