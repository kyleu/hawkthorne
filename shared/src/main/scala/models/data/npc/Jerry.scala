/* Generated File */
package models.data.npc

import models.template.npc.NpcTemplate

object Jerry extends NpcTemplate(
  key = "jerry",
  name = "Jerry",
  width = 32,
  height = 48,
  greeting = Some("Hey-oh! I am the janitor around {{olive}}Greendale{{white}}, you can call me {{red_light}}Jerry{{white}}."),
  noInventory = None,
  noCommands = None,
  animations = Seq.empty
)
