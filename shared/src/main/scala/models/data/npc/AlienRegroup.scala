/* Generated File */
package models.data.npc

import models.template.npc.NpcTemplate

object AlienRegroup extends NpcTemplate(
  key = "alien_regroup",
  name = "AlienRegroup",
  width = 29,
  height = 48,
  greeting = None,
  noInventory = Some("Calm down there human, I'll sell you my supplies when I get back to my cave."),
  noCommands = None,
  animations = Seq.empty
)
