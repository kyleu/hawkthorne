/* Generated File */
package models.data.npc

import models.animation.Animation
import models.template.npc.NpcTemplate

object HumanBeing extends NpcTemplate(
  key = "humanbeing",
  name = "HumanBeing",
  width = 32,
  height = 48,
  greeting = Some("Mummmm?"),
  noInventory = Some("Mum Mont Muve Mummfmen Mo Murm Muu."),
  noCommands = Some("Mum Mont Muurk Murunds Urm Muu."),
  animations = Seq(
    Animation(id = "default.", frames = IndexedSeq(0, 10), delay = 0.5, loop = true),
    Animation(id = "walking.", frames = IndexedSeq(0, 1, 2), delay = 0.2, loop = true)
  )
)
