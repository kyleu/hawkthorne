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
  talkItems = Seq[TalkItem](
    TalkItem(prompt = "I am done with you", responses = Nil),
    TalkItem(prompt = "Where is ...", responses = Nil, children = Seq(
      TalkItem(prompt = "I am done with you", responses = Nil),
      TalkItem(prompt = "The registrar", responses = Nil),
      TalkItem(prompt = "The ac repair school", responses = Nil),
      TalkItem(prompt = "My valentine", responses = Nil),
      TalkItem(prompt = "My dignity", responses = Nil),
      TalkItem(prompt = "Magnitude", responses = Nil),
      TalkItem(prompt = "The dean's office", responses = Nil)
    )),
    TalkItem(prompt = "Why are you mumbling?", responses = Nil),
    TalkItem(prompt = "Who are you?", responses = Nil)
  )
)
