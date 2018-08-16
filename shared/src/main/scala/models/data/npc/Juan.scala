/* Generated File */
package models.data.npc

import models.animation.Animation
import models.npc.TalkItem
import models.template.npc.NpcTemplate

object Juan extends NpcTemplate(
  key = "juan1",
  name = "Juan",
  width = 32,
  height = 48,
  greeting = Some("My name is {{red_light}}Juan{{white}}, I spend my days lazying around {{olive}}Tacotown{{white}}."),
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(0, 10), delay = 0.5, loop = true),
    Animation(id = "walking", frames = IndexedSeq(0, 1, 2), delay = 0.2, loop = true)
  ),
  noInventory = None,
  noCommands = None,
  talkItems = Seq[TalkItem]( /* TalkItem(prompt = "i am done with you", responses = Nil)
      ['text']='More options...', ['option']={ (1)
      TalkItem(prompt = "Lay off that booze, pal", responses = Nil)
      TalkItem(prompt = "You own that goat farm?', freeze = true", responses = Nil)
      TalkItem(prompt = "Tell me about this place", responses = Nil)
      TalkItem(prompt = "I could sure use a beer", responses = Nil)
      } (0)
    TalkItem(prompt = "Any useful info for me?", responses = Nil)
      ['text']='Donde esta...', ['option']={ (1)
      TalkItem(prompt = "Castle Hawkthorne?", responses = Nil)
      TalkItem(prompt = "the town blacksmith?", responses = Nil)
      TalkItem(prompt = "the sandpits?", responses = Nil)
      TalkItem(prompt = "la biblioteca?", responses = Nil) */ )
)
