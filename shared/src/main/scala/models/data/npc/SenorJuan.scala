/* Generated File */
package models.data.npc

import models.template.npc.NpcTemplate

object SenorJuan extends NpcTemplate(
  key = "senorjuan",
  name = "SenorJuan",
  width = 32,
  height = 48,
  greeting = Some("My name is {{red_light}}Senor Juan{{white}}. I guard this {{orange}}fence{{white}}."),
  noInventory = None,
  noCommands = None,
  animations = Seq.empty
)
