/* Generated File */
package models.data.npc

import models.npc.NpcTemplate

object XmasWizard extends NpcTemplate(
  key = "xmaswizard",
  name = "XmasWizard",
  width = 32,
  height = 48,
  greeting = Some("Hello and welcome to {{teal}}Winter Wonderland{{white}}!"),
  noInventory = None,
  noCommands = None,
  animations = Seq.empty
)
