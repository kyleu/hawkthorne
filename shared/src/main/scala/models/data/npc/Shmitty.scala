/* Generated File */
package models.data.npc

import models.template.npc.NpcTemplate

object Shmitty extends NpcTemplate(
  key = "shmitty",
  name = "Shmitty",
  width = 48,
  height = 48,
  greeting = Some("Oh man, {{red_dark}}shmitty alert!{{white}}"),
  noInventory = None,
  noCommands = Some("We don't take commands from shmitty.  Uh-duh!"),
  animations = Seq.empty
)
