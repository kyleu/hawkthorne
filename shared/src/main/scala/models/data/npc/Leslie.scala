/* Generated File */
package models.data.npc

import models.animation.Animation
import models.npc.TalkItem
import models.template.npc.NpcTemplate

object Leslie extends NpcTemplate(
  key = "leslie",
  name = "Leslie",
  width = 48,
  height = 48,
  greeting = Some("I am {{red_light}}Leslie{{white}}, I travel around looking for interesting wares that I can sell."),
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(0, 1, 0, 0, 0, 0), delay = 0.5, loop = true)
  ),
  noInventory = None,
  noCommands = None,
  talkItems = Seq[TalkItem](
    TalkItem(prompt = "I am done with you", responses = Nil),
    TalkItem(prompt = "Can I buy you a drink?", responses = List("Sorry, I have a girlfriend.")),
    TalkItem(prompt = "Any useful info for me?", responses = List("You will need some weapons and potions if you are going to survive.")),
    TalkItem(prompt = "Hello!", responses = List("Hello! I'm {{red_light}}Leslie{{white}}, a travelling Sales-bian from the {{olive}}Plaid Plateau{{white}}."))
  )
)
