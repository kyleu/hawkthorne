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
  talkItems = Seq[TalkItem](
    TalkItem(prompt = "I am done with you", responses = Nil),
    TalkItem(prompt = "Alright, look kids...", responses = List("Shmitty!!", "Get out of here you loser.")),
    TalkItem(prompt = "You kids are horrible.", responses = List("Says the loser attending a community college. Shmitty!")),
    TalkItem(prompt = "Uh-duh!", responses = List("Uh-duhhhh!"), children = Seq(
      TalkItem(prompt = "Uh-duh!", responses = List("Uh-duhhhh!")),
      TalkItem(prompt = "Uh-duh!", responses = List("Uh-duhhhh!")),
      TalkItem(prompt = "Uh-duh!", responses = List("Uh-duhhhh!")),
      TalkItem(prompt = "Uh-duh!", responses = List("Uh-duhhhh!"))
    ))
  )
)
