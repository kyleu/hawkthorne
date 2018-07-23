/* Generated File */
package models.data.npc

import models.animation.Animation
import models.template.npc.NpcTemplate

object NotStarburns extends NpcTemplate(
  key = "notstarburns",
  name = "NotStarburns",
  width = 24,
  height = 15,
  greeting = None,
  noInventory = None,
  noCommands = None,
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(0, 1, 2, 0, 0, 0), delay = 0.5, loop = true)
  )
)
