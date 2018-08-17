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
  talkItems = Seq[TalkItem](
    TalkItem(prompt = "I am done with you", responses = Nil),
    TalkItem(prompt = "Any useful info for me?", responses = List("I hear {{grey}}Castle Hawkthorne{{white}} holds untold riches, if anyone could get to them.", "One of them, I hear, is a key that unlocks a fabled world called {{olive}}Greendale{{white}}.", "Now there's what I call an adventure.")),
    TalkItem(prompt = "This town is in ruins!", responses = List("It's that damned {{grey}}Hawkthorne{{white}}! He's a madman, that's what he is.", "Just sitting in that ivory tower of his, it's his fault we're in shambles like this.")),
    TalkItem(prompt = "Talk about the Acorn King", responses = Nil)
  )
)
