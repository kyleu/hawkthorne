/* Generated File */
package models.data.npc

import models.template.npc.NpcTemplate

object MayorJuan extends NpcTemplate(
  key = "mayorjuan",
  name = "MayorJuan",
  width = 48,
  height = 48,
  greeting = Some("My name is {{red_light}}Juan{{white}}, I am the mayor of {{olive}}Tacotown{{white}}."),
  noInventory = None,
  noCommands = None,
  animations = Seq.empty
)
