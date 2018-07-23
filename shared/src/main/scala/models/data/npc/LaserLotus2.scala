/* Generated File */
package models.data.npc

import models.animation.Animation
import models.template.npc.NpcTemplate

object LaserLotus2 extends NpcTemplate(
  key = "laserlotus2",
  name = "LaserLotus2",
  width = 24,
  height = 48,
  greeting = None,
  noInventory = Some("I don't have anything to sell at the moment, sorry!"),
  noCommands = Some("No one commands me but the Great Buddha himself!"),
  animations = Seq(
    Animation(id = "default.", frames = IndexedSeq(1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0), delay = 0.25, loop = true),
    Animation(id = "walking.", frames = IndexedSeq(0, 1, 2), delay = 0.2, loop = true)
  )
)
