/* Generated File */
package models.data.npc

import models.animation.Animation
import models.npc.TalkItem
import models.template.npc.NpcTemplate

object LaserLotus2 extends NpcTemplate(
  key = "laserlotus2",
  name = "LaserLotus2",
  width = 24,
  height = 48,
  greeting = None,
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0), delay = 0.25, loop = true),
    Animation(id = "walking", frames = IndexedSeq(0, 1, 2), delay = 0.2, loop = true)
  ),
  noInventory = Some("I don't have anything to sell at the moment, sorry!"),
  noCommands = Some("No one commands me but the Great Buddha himself!"),
  talkItems = Seq[TalkItem](
    TalkItem(prompt = "I am done with you", responses = Nil),
    TalkItem(prompt = "Who are you?", responses = List("I am a follower of the {{blue_light}}Reformed Neo Buddhism Church{{white}}!", "I am merely a level 3 laser lotus at the moment, but I'll get there!")),
    TalkItem(prompt = "I am looking for a quest!", responses = Nil),
    TalkItem(prompt = "Anything in these mines?", responses = List("We haven't fully explored the mines yet, but there's supposedly a lot of important documents in a library at the end of the tunnel!", "Spellbooks, scrolls, maps...you know the stuff.", "The key to the mine carts is in the {{red}}storage room{{white}}, but we still haven't gotten around to searching for it, we'll probably get to it later."))
  )
)
