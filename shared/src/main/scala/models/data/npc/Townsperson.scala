/* Generated File */
package models.data.npc

import models.animation.Animation
import models.template.npc.NpcTemplate

object Townsperson extends NpcTemplate(
  key = "townsperson",
  name = "Townsperson",
  width = 32,
  height = 48,
  greeting = None,
  noInventory = None,
  noCommands = None,
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(0, 10), delay = 0.5, loop = true),
    Animation(id = "walking", frames = IndexedSeq(0, 1, 2), delay = 0.2, loop = true)
  )
)
