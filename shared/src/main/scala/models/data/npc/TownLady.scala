/* Generated File */
package models.data.npc

import models.template.npc.NpcTemplate

object TownLady extends NpcTemplate(
  key = "townlady",
  name = "TownLady",
  width = 27,
  height = 42,
  greeting = Some("Huh? What did ya say?"),
  noInventory = None,
  noCommands = None,
  animations = Seq.empty
)
