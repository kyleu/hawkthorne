/* Generated File */
package models.data.npc

import models.npc.NpcTemplate

object Hilda extends NpcTemplate(
  key = "hilda",
  name = "Hilda",
  width = 32,
  height = 48,
  greeting = Some("I am {{red_light}}Hilda{{white}}, I live in the {{olive}}village{{white}}."),
  noInventory = None,
  noCommands = None,
  animations = Seq.empty
)
