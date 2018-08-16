/* Generated File */
package models.data.npc

import models.animation.Animation
import models.npc.TalkItem
import models.template.npc.NpcTemplate

object MayorJuan extends NpcTemplate(
  key = "mayorjuan",
  name = "MayorJuan",
  width = 48,
  height = 48,
  greeting = Some("My name is {{red_light}}Juan{{white}}, I am the mayor of {{olive}}Tacotown{{white}}."),
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(0, 1), delay = 0.4, loop = true)
  ),
  noInventory = None,
  noCommands = None,
  talkItems = Seq[TalkItem]( /* TalkItem(prompt = "i am done with you", responses = Nil)
    TalkItem(prompt = "Sick moustache!", responses = Nil)
      ['text']='Donde esta...', ['option']={ (1)
      TalkItem(prompt = "the sandpits?", responses = Nil)
      TalkItem(prompt = "the town hall?", responses = Nil)
      TalkItem(prompt = "the chili fields?", responses = Nil)
      TalkItem(prompt = "la biblioteca?", responses = Nil)
      } (0)
      ['text']='So you are the mayor?', ['option']={ (1)
      TalkItem(prompt = "Why is the exit blocked?", responses = Nil)
      TalkItem(prompt = "Why is the town so dirty?", responses = Nil)
      TalkItem(prompt = "Tell me about this place", responses = Nil)
      TalkItem(prompt = "How do I get out of here?", responses = Nil) */ )
)
