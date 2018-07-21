/* Generated File */
package models.data.npc

import models.npc.NpcTemplate

object Leslie extends NpcTemplate(
  key = "leslie",
  name = "Leslie",
  width = 48,
  height = 48,
  greeting = Some("I am {{red_light}}Leslie{{white}}, I travel around looking for interesting wares that I can sell."),
  noInventory = None,
  noCommands = None,
  animations = Seq.empty
)
