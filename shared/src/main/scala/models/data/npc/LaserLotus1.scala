/* Generated File */
package models.data.npc

import models.animation.Animation
import models.npc.TalkItem
import models.template.npc.NpcTemplate

object LaserLotus1 extends NpcTemplate(
  key = "laserlotus1",
  name = "LaserLotus1",
  width = 24,
  height = 48,
  greeting = None,
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 3, 4), delay = 0.25, loop = true),
    Animation(id = "walking", frames = IndexedSeq(0, 1, 2), delay = 0.2, loop = true)
  ),
  noInventory = None,
  noCommands = Some("I only take commands from a laser lotus above level 7 or the Great Buddha himself!"),
  talkItems = Seq[TalkItem](
    TalkItem(prompt = "I am done with you", responses = Nil),
    TalkItem(prompt = "Who are you?", responses = List("I am a follower of the {{blue_light}}Reformed Neo Buddhism Church{{white}}!", "I am merely a level 3 laser lotus at the moment, but I'll get there!")),
    TalkItem(prompt = "What cult is this?", responses = List("It is not a cult, it's a way of life!", "When Buddha arrived in a meteor, he taught us forgiveness, love and lasers!", "When he returns, we shall bathe in the shimmering ocean of knowledge together!")),
    TalkItem(prompt = "Why are you in a cave?", responses = List("Our headquarters is actually situated in a hidden valley in the mountains.", "This is simply just one of the many outposts we have."))
  )
)
