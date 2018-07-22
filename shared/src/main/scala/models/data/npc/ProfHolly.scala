/* Generated File */
package models.data.npc

import models.template.npc.NpcTemplate

object ProfHolly extends NpcTemplate(
  key = "profholly",
  name = "ProfHolly",
  width = 32,
  height = 48,
  greeting = Some("Hello, my precious blueberry! You can call me {{red_light}}Professor Holly{{white}}."),
  noInventory = Some("Sorry, blueberry. All I have is on the shelves!"),
  noCommands = Some("Command is such a strong, ugly word."),
  animations = Seq.empty
)
