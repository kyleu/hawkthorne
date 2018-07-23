/* Generated File */
package models.data.npc

import models.animation.Animation
import models.template.npc.NpcTemplate

object Hermit extends NpcTemplate(
  key = "hermit",
  name = "Hermit",
  width = 24,
  height = 48,
  greeting = None,
  noInventory = None,
  noCommands = None,
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 0, 1, 0, 1), delay = 0.28, loop = true)
  )
)
