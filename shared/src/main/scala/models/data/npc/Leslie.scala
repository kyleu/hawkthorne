/* Generated File */
package models.data.npc

import models.animation.Animation
import models.template.npc.NpcTemplate

object Leslie extends NpcTemplate(
  key = "leslie",
  name = "Leslie",
  width = 48,
  height = 48,
  greeting = Some("I am {{red_light}}Leslie{{white}}, I travel around looking for interesting wares that I can sell."),
  noInventory = None,
  noCommands = None,
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(0, 1, 0, 0, 0, 0), delay = 0.5, loop = true)
  )
)
