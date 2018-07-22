/* Generated File */
package models.data.npc

import models.template.npc.NpcTemplate

object Juan extends NpcTemplate(
  key = "juan1",
  name = "Juan",
  width = 32,
  height = 48,
  greeting = Some("My name is {{red_light}}Juan{{white}}, I spend my days lazying around {{olive}}Tacotown{{white}}."),
  noInventory = None,
  noCommands = None,
  animations = Seq.empty
)
