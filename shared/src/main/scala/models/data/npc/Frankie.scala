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
  talkItems = Seq[TalkItem]( /* TalkItem(prompt = "i am done with you", responses = Nil)
      ['text']='Save Greendale!', ['option']={ (1)
      TalkItem(prompt = "De-electrify pool', freeze = true", responses = Nil)
      TalkItem(prompt = "Lost office key!', freeze = true", responses = Nil)
      TalkItem(prompt = "Mail Diane', freeze = true", responses = Nil)
      TalkItem(prompt = "Potatoes on rooftops', freeze = true", responses = Nil)
      TalkItem(prompt = "Bones in the parking lot', freeze = true", responses = Nil)
      TalkItem(prompt = "Peanut Costume', freeze = true", responses = Nil)
      } (0)
    TalkItem(prompt = "Are you the IT lady?", responses = Nil) */ )
)
