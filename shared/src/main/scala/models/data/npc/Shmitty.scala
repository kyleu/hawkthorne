/* Generated File */
package models.data.npc

import models.animation.Animation
import models.npc.TalkItem
import models.template.npc.NpcTemplate

object Shmitty extends NpcTemplate(
  key = "shmitty",
  name = "Shmitty",
  width = 48,
  height = 48,
  greeting = Some("Oh man, {{red_dark}}shmitty alert!{{white}}"),
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(0, 3, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 2, 0, 0, 0), delay = 0.2, loop = true)
  ),
  noInventory = None,
  noCommands = Some("We don't take commands from shmitty.  Uh-duh!"),
  talkItems = Seq[TalkItem]( /* TalkItem(prompt = "i am done with you", responses = Nil)
    TalkItem(prompt = "Alright, look kids...", responses = Nil)
    TalkItem(prompt = "You kids are horrible.", responses = Nil)
      ['text']='Uh-duh!', ['option']={ (1)
      TalkItem(prompt = "Uh-duh!", responses = Nil)
      TalkItem(prompt = "Uh-duh!", responses = Nil)
      TalkItem(prompt = "Uh-duh!", responses = Nil)
      TalkItem(prompt = "Uh-duh!", responses = Nil) */ )
)
