/* Generated File */
package models.data.npc

import models.animation.Animation
import models.npc.TalkItem
import models.template.npc.NpcTemplate

object BabyAbed extends NpcTemplate(
  key = "babyabed",
  name = "BabyAbed",
  width = 20,
  height = 25,
  greeting = None,
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(0), delay = 0.5, loop = true),
    Animation(id = "walking", frames = IndexedSeq(2, 3), delay = 0.2, loop = true)
  ),
  noInventory = Some("cool cool cool"),
  noCommands = Some("cool cool cool"),
  talkItems = Seq[TalkItem](
    TalkItem(prompt = "Cool cool cool", responses = Nil),
    TalkItem(prompt = "Cool cool cool", responses = Nil),
    TalkItem(prompt = "Cool cool cool", responses = Nil),
    TalkItem(prompt = "Cool cool cool", responses = Nil)
  )
)
