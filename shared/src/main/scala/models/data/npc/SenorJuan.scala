/* Generated File */
package models.data.npc

import models.animation.Animation
import models.npc.TalkItem
import models.template.npc.NpcTemplate

object SenorJuan extends NpcTemplate(
  key = "senorjuan",
  name = "SenorJuan",
  width = 32,
  height = 48,
  greeting = Some("My name is {{red_light}}Senor Juan{{white}}. I guard this {{orange}}fence{{white}}."),
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(0, 10), delay = 0.5, loop = true),
    Animation(id = "walking", frames = IndexedSeq(0, 1, 2), delay = 0.2, loop = true)
  ),
  noInventory = None,
  noCommands = None,
  talkItems = Seq[TalkItem]( /* TalkItem(prompt = "Where\'s your hat?", responses = Nil)
    TalkItem(prompt = "Who are you?", responses = Nil)
    TalkItem(prompt = "Is there another way out?", responses = Nil)
      ['text']='Tell me about this fence', ['option']={ (1)
      TalkItem(prompt = "Who put this here?", responses = Nil)
      TalkItem(prompt = "Why is this here?", responses = Nil)
      TalkItem(prompt = "Can I pass?", responses = Nil)
      TalkItem(prompt = "Why are you guarding it?", responses = Nil) */ )
)
