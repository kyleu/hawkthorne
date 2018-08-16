/* Generated File */
package models.data.npc

import models.animation.Animation
import models.npc.TalkItem
import models.template.npc.NpcTemplate

object Juanita extends NpcTemplate(
  key = "juanita",
  name = "Juanita",
  width = 32,
  height = 48,
  greeting = Some("I am {{red_light}}Juanita{{white}}, I live in {{olive}}Tacotown{{white}}."),
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(10, 10, 10, 9), delay = 0.5, loop = true),
    Animation(id = "walking", frames = IndexedSeq(0), delay = 0.2, loop = true)
  ),
  noInventory = None,
  noCommands = None,
  talkItems = Seq[TalkItem]( /* TalkItem(prompt = "i am done with you", responses = Nil)
    TalkItem(prompt = "You look very busy', freeze = true", responses = Nil)
    TalkItem(prompt = "Any useful info for me?", responses = Nil)
      ['text']='Donde esta...', ['option']={ (1)
      TalkItem(prompt = "the sandpits?", responses = Nil)
      TalkItem(prompt = "the town mayor?", responses = Nil)
      TalkItem(prompt = "Gay Island?", responses = Nil)
      TalkItem(prompt = "la biblioteca?", responses = Nil) */ )
)
