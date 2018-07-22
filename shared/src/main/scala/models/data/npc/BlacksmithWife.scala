/* Generated File */
package models.data.npc

import models.template.npc.NpcTemplate

object BlacksmithWife extends NpcTemplate(
  key = "blacksmith_wife",
  name = "BlacksmithWife",
  width = 48,
  height = 48,
  greeting = None,
  noInventory = Some("Talk to my husband to about supplies."),
  noCommands = None,
  animations = Seq.empty
)
