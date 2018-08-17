/* Generated File */
package models.data.npc

import models.animation.Animation
import models.npc.TalkItem
import models.template.npc.NpcTemplate

object Frankie extends NpcTemplate(
  key = "frankie",
  name = "Frankie",
  width = 24,
  height = 48,
  greeting = Some("I am a big believer in hierarchy. Someone needs to say that I am in charge, and that person is me."),
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(0, 0, 0, 1), delay = 0.25, loop = true)
  ),
  noInventory = None,
  noCommands = None,
  talkItems = Seq[TalkItem](
    TalkItem(prompt = "I am done with you", responses = Nil),
    TalkItem(prompt = "Save Greendale!", responses = List("I am part of the {{green_light}}Save Greendale Committee{{white}}, but there's just too many things to do!", "I would be extremely grateful if you were to lend me a hand with my tasks."), children = Seq(
      TalkItem(prompt = "De-electrify pool", responses = Nil),
      TalkItem(prompt = "Lost office key!", responses = Nil),
      TalkItem(prompt = "Mail Diane", responses = Nil),
      TalkItem(prompt = "Potatoes on rooftops", responses = Nil),
      TalkItem(prompt = "Bones in the parking lot", responses = Nil),
      TalkItem(prompt = "Peanut Costume", responses = Nil)
    )),
    TalkItem(prompt = "Are you the IT lady?", responses = List("No, I'm not! People keep asking me that and I have no idea why.", "I'm sure the previous IT lady had a good reason to quit her job.")),
    TalkItem(prompt = "How is Greendale?", responses = List("This school is weird, gross, and passionate.", "But mostly weird and gross."))
  )
)
