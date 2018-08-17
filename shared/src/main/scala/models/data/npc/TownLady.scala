/* Generated File */
package models.data.npc

import models.animation.Animation
import models.npc.TalkItem
import models.template.npc.NpcTemplate

object TownLady extends NpcTemplate(
  key = "townlady",
  name = "TownLady",
  width = 27,
  height = 42,
  greeting = Some("Huh? What did ya say?"),
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(0), delay = 0.5, loop = true),
    Animation(id = "walking", frames = IndexedSeq(3, 4, 5), delay = 0.2, loop = true)
  ),
  noInventory = None,
  noCommands = None,
  talkItems = Seq[TalkItem](
    TalkItem(prompt = "I am done with you", responses = Nil),
    TalkItem(prompt = "Pardon?", responses = List("Speak up! I can't hear a thing you're sayin'!")),
    TalkItem(prompt = "Say again?", responses = List("Speak up! I can't hear a thing you're sayin'!")),
    TalkItem(prompt = "Talk about the Acorn King", responses = List("Speak up! I can't hear a thing you're sayin'!"))
  )
)
