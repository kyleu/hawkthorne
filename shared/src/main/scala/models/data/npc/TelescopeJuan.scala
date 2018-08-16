/* Generated File */
package models.data.npc

import models.animation.Animation
import models.npc.TalkItem
import models.template.npc.NpcTemplate

object TelescopeJuan extends NpcTemplate(
  key = "telescopejuan",
  name = "TelescopeJuan",
  width = 48,
  height = 48,
  greeting = Some("My name is {{red_light}}Juan{{white}}. I am the resident astronomer of {{olive}}Tacotown{{white}}."),
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(0, 1), delay = 0.6, loop = true),
    Animation(id = "startled", frames = IndexedSeq(2, 3), delay = 0.5, loop = false),
    Animation(id = "talking", frames = IndexedSeq(4, 4, 4, 4, 5), delay = 0.5, loop = true)
  ),
  noInventory = None,
  noCommands = None,
  talkItems = Seq[TalkItem]( /* TalkItem(prompt = "i am done with you", responses = Nil)
    TalkItem(prompt = "Any useful info for me?", responses = Nil)
    TalkItem(prompt = "So you believe in aliens?", responses = Nil) */ )
)
