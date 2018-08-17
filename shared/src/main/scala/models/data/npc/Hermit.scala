/* Generated File */
package models.data.npc

import models.animation.Animation
import models.npc.TalkItem
import models.template.npc.NpcTemplate

object Hermit extends NpcTemplate(
  key = "hermit",
  name = "Hermit",
  width = 24,
  height = 48,
  greeting = None,
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 0, 1, 0, 1), delay = 0.28, loop = true)
  ),
  noInventory = None,
  noCommands = None,
  talkItems = Seq[TalkItem](
    TalkItem(prompt = "I am done with you", responses = Nil),
    TalkItem(prompt = "Any useful info for me?", responses = List("There's a buncha' chests hidden around these parts for some reason, check them out to see what you get!")),
    TalkItem(prompt = "Why do you live out here?", responses = List("The nature, the trees, the wee-I mean, the water.", "Though it's getting dangerous these days with all them angry acorns out and about...")),
    TalkItem(prompt = "Talk about quests", responses = Nil)
  )
)
