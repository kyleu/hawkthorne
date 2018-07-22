/* Generated File */
package models.data.npc

import models.template.npc.NpcTemplate

object GayNpc extends NpcTemplate(
  key = "gaynpc",
  name = "GayNpc",
  width = 32,
  height = 48,
  greeting = Some("Heeeyyyyyyyy-o, my name is {{red_light}}Fenton{{white}}!"),
  noInventory = None,
  noCommands = None,
  animations = Seq.empty
)
