/* Generated File */
package models.data.npc

import models.animation.Animation
import models.npc.TalkItem
import models.template.npc.NpcTemplate

object AnniesBoobs extends NpcTemplate(
  key = "anniesboobs",
  name = "AnniesBoobs",
  width = 32,
  height = 48,
  greeting = None,
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(0, 10), delay = 0.5, loop = true),
    Animation(id = "walking", frames = IndexedSeq(0, 1, 2), delay = 0.2, loop = true)
  ),
  noInventory = Some("(The monkey points forward eagerly.)"),
  noCommands = Some("(The monkey blows a raspberry at you.)"),
  talkItems = Seq[TalkItem](
    TalkItem(prompt = "I am done with you", responses = Nil),
    TalkItem(prompt = "Who is a good monkey?", responses = List("SCREE!!!")),
    TalkItem(prompt = "Did you see a purple pen?", responses = List("(The monkey is more interested in the spoon than talking to you.)")),
    TalkItem(prompt = "Hello!", responses = List("Ook, ook, eek!"))
  )
)
