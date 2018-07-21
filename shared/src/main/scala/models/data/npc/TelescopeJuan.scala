/* Generated File */
package models.data.npc

import models.npc.NpcTemplate

object TelescopeJuan extends NpcTemplate(
  key = "telescopejuan",
  name = "TelescopeJuan",
  width = 48,
  height = 48,
  greeting = Some("My name is {{red_light}}Juan{{white}}. I am the resident astronomer of {{olive}}Tacotown{{white}}."),
  noInventory = None,
  noCommands = None,
  animations = Seq.empty
)
