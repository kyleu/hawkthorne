/* Generated File */
package models.data.npc

import models.npc.NpcTemplate

object TownKnight extends NpcTemplate(
  key = "townknight",
  name = "TownKnight",
  width = 70,
  height = 55,
  greeting = Some("My name is {{red_light}}Sir Merek{{white}}, I became a knight to protect this {{olive}}village{{white}} from the dangers of the forest."),
  noInventory = None,
  noCommands = None,
  animations = Seq.empty
)
