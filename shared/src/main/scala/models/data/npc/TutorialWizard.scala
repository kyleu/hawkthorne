/* Generated File */
package models.data.npc

import models.npc.NpcTemplate

object TutorialWizard extends NpcTemplate(
  key = "tutorial_wizard",
  name = "TutorialWizard",
  width = 32,
  height = 48,
  greeting = Some("Hello and welcome to {{teal}}The Test Level{{white}}!"),
  noInventory = None,
  noCommands = None,
  animations = Seq.empty
)
