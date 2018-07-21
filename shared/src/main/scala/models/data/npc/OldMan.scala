/* Generated File */
package models.data.npc

import models.npc.NpcTemplate

object OldMan extends NpcTemplate(
  key = "oldman",
  name = "OldMan",
  width = 32,
  height = 32,
  greeting = Some("Bah! Go away."),
  noInventory = None,
  noCommands = None,
  animations = Seq.empty
)
