/* Generated File */
package models.data.npc

import models.animation.Animation
import models.npc.TalkItem
import models.template.npc.NpcTemplate

object HumanBeing extends NpcTemplate(
  key = "humanbeing",
  name = "HumanBeing",
  width = 32,
  height = 48,
  greeting = Some("Mummmm?"),
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(0, 10), delay = 0.5, loop = true),
    Animation(id = "walking", frames = IndexedSeq(0, 1, 2), delay = 0.2, loop = true)
  ),
  noInventory = Some("Mum Mont Muve Mummfmen Mo Murm Muu."),
  noCommands = Some("Mum Mont Muurk Murunds Urm Muu."),
  talkItems = Seq[TalkItem]( /* TalkItem(prompt = "i am done with you", responses = Nil)
      ['text']='where is ...', ['option']={ (1)
      TalkItem(prompt = "i am done with you", responses = Nil)
      TalkItem(prompt = ""the registrar"", responses = Nil)
      TalkItem(prompt = ""the ac repair school"", responses = Nil)
      TalkItem(prompt = ""my valentine"", responses = Nil)
      TalkItem(prompt = ""my dignity"", responses = Nil)
      TalkItem(prompt = ""magnitude"", responses = Nil)
      TalkItem(prompt = ""the dean's office",", responses = Nil)
      } (0)
    TalkItem(prompt = "why are you mumbling?", responses = Nil) */ )
)
