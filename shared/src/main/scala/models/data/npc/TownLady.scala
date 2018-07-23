/* Generated File */
package models.data.npc

import models.animation.Animation
import models.template.npc.NpcTemplate

object TownLady extends NpcTemplate(
  key = "townlady",
  name = "TownLady",
  width = 27,
  height = 42,
  greeting = Some("Huh? What did ya say?"),
  noInventory = None,
  noCommands = None,
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(0), delay = 0.5, loop = true),
    Animation(id = "walking", frames = IndexedSeq(3, 4, 5), delay = 0.2, loop = true)
  )
)
