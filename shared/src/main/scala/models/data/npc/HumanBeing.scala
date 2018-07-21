/* Generated File */
package models.data.npc

import models.npc.NpcTemplate

object HumanBeing extends NpcTemplate(
  key = "humanbeing",
  name = "HumanBeing",
  width = 32,
  height = 48,
  greeting = Some("Mummmm?"),
  noInventory = Some("Mum Mont Muve Mummfmen Mo Murm Muu."),
  noCommands = Some("Mum Mont Muurk Murunds Urm Muu."),
  animations = Seq.empty
)
