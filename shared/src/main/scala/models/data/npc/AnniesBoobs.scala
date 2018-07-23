/* Generated File */
package models.data.npc

import models.animation.Animation
import models.template.npc.NpcTemplate

object AnniesBoobs extends NpcTemplate(
  key = "anniesboobs",
  name = "AnniesBoobs",
  width = 32,
  height = 48,
  greeting = None,
  noInventory = Some("(The monkey points forward eagerly.)"),
  noCommands = Some("(The monkey blows a raspberry at you.)"),
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(0, 10), delay = 0.5, loop = true),
    Animation(id = "walking", frames = IndexedSeq(0, 1, 2), delay = 0.2, loop = true)
  )
)
