/* Generated File */
package models.data.npc

import models.template.npc.NpcTemplate

object Juanita extends NpcTemplate(
  key = "juanita",
  name = "Juanita",
  width = 32,
  height = 48,
  greeting = Some("I am {{red_light}}Juanita{{white}}, I live in {{olive}}Tacotown{{white}}."),
  noInventory = None,
  noCommands = None,
  animations = Seq.empty
)
