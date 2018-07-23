/* Generated File */
package models.data.npc

import models.animation.Animation
import models.template.npc.NpcTemplate

object Shmitty extends NpcTemplate(
  key = "shmitty",
  name = "Shmitty",
  width = 48,
  height = 48,
  greeting = Some("Oh man, {{red_dark}}shmitty alert!{{white}}"),
  noInventory = None,
  noCommands = Some("We don't take commands from shmitty.  Uh-duh!"),
  animations = Seq(
    Animation(id = "default.", frames = IndexedSeq(0, 3, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 2, 0, 0, 0), delay = 0.2, loop = true)
  )
)
