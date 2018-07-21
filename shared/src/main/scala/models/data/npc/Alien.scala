/* Generated File */
package models.data.npc

import models.npc.NpcTemplate

object Alien extends NpcTemplate(
  key = "alien",
  name = "Alien",
  width = 29,
  height = 48,
  greeting = Some("An adventurer! You might just be what I need..."),
  noInventory = None,
  noCommands = None,
  animations = Seq.empty
)
