/* Generated File */
package models.data.npc

import models.animation.Animation
import models.template.npc.NpcTemplate

object BlacksmithJuan extends NpcTemplate(
  key = "blacksmithjuan",
  name = "BlacksmithJuan",
  width = 48,
  height = 48,
  greeting = None,
  noInventory = None,
  noCommands = None,
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(0, 1), delay = 0.2, loop = true)
  )
)
