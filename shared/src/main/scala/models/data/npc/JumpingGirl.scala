/* Generated File */
package models.data.npc

import models.animation.Animation
import models.template.npc.NpcTemplate

object JumpingGirl extends NpcTemplate(
  key = "jumpinggirl",
  name = "JumpingGirl",
  width = 24,
  height = 48,
  greeting = None,
  noInventory = None,
  noCommands = None,
  animations = Seq(
    Animation(id = "default.", frames = IndexedSeq(12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23), delay = 0.05, loop = true),
    Animation(id = "walking.", frames = IndexedSeq(12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23), delay = 0.05, loop = true)
  )
)
