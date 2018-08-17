/* Generated File */
package models.data.npc

import models.animation.Animation
import models.npc.TalkItem
import models.template.npc.NpcTemplate

object NotStarburns extends NpcTemplate(
  key = "notstarburns",
  name = "NotStarburns",
  width = 24,
  height = 15,
  greeting = None,
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(0, 1, 2, 0, 0, 0), delay = 0.5, loop = true)
  ),
  noInventory = None,
  noCommands = None,
  talkItems = Seq[TalkItem](
    TalkItem(prompt = "I am done with you", responses = Nil),
    TalkItem(prompt = "Do I smell...meth?", responses = List("Only the best, courtesy of a pal from Albuquerque.", "It'll cost you a pretty penny, but it'll really break some enemies. Real bad.")),
    TalkItem(prompt = "Star Burns?", responses = List("Never heard of him!", "My name is Alex!")),
    TalkItem(prompt = "Anybody here?", responses = List("...Who wants to know?"))
  )
)
