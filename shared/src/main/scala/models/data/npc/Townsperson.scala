/* Generated File */
package models.data.npc

import models.animation.Animation
import models.npc.TalkItem
import models.template.npc.NpcTemplate

object Townsperson extends NpcTemplate(
  key = "townsperson",
  name = "Townsperson",
  width = 32,
  height = 48,
  greeting = None,
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(0, 10), delay = 0.5, loop = true),
    Animation(id = "walking", frames = IndexedSeq(0, 1, 2), delay = 0.2, loop = true)
  ),
  noInventory = None,
  noCommands = None,
  talkItems = Seq[TalkItem](
    TalkItem(prompt = "I am done with you", responses = Nil),
    TalkItem(prompt = "What are you carrying?", responses = List("It's a piece of wood. The town {{green_light}}blacksmith{{white}} needs it to make his weapons.", "You can find him at the last house on the street.")),
    TalkItem(prompt = "This town is in ruins!", responses = List("Ever since that tyrant {{grey}}Hawkthorne{{white}} started ruling", "Our town started falling apart into pieces. If only he were overthrown!")),
    TalkItem(prompt = "Talk about the Acorn King", responses = Nil)
  )
)
