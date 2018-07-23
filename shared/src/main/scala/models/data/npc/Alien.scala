/* Generated File */
package models.data.npc

import models.animation.Animation
import models.template.npc.NpcTemplate

object Alien extends NpcTemplate(
  key = "alien",
  name = "Alien",
  width = 29,
  height = 48,
  greeting = Some("An adventurer! You might just be what I need..."),
  noInventory = None,
  noCommands = None,
  animations = Seq(
    Animation(id = "default.", frames = IndexedSeq(1), delay = 0.5, loop = true),
    Animation(id = "walking.", frames = IndexedSeq(7, 8, 9), delay = 0.2, loop = true)
  )
)
