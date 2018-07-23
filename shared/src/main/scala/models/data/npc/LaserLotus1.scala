/* Generated File */
package models.data.npc

import models.animation.Animation
import models.template.npc.NpcTemplate

object LaserLotus1 extends NpcTemplate(
  key = "laserlotus1",
  name = "LaserLotus1",
  width = 24,
  height = 48,
  greeting = None,
  noInventory = None,
  noCommands = Some("I only take commands from a laser lotus above level 7 or the Great Buddha himself!"),
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 3, 4), delay = 0.25, loop = true),
    Animation(id = "walking", frames = IndexedSeq(0, 1, 2), delay = 0.2, loop = true)
  )
)
