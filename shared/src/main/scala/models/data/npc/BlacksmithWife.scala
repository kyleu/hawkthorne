/* Generated File */
package models.data.npc

import models.animation.Animation
import models.template.npc.NpcTemplate

object BlacksmithWife extends NpcTemplate(
  key = "blacksmith_wife",
  name = "BlacksmithWife",
  width = 48,
  height = 48,
  greeting = None,
  noInventory = Some("Talk to my husband to about supplies."),
  noCommands = None,
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(0, 1), delay = 0.5, loop = true),
    Animation(id = "hurt", frames = IndexedSeq(4, 5, 6, 7), delay = 0.2, loop = true),
    Animation(id = "dying", frames = IndexedSeq(2, 3), delay = 0.15, loop = false),
    Animation(id = "exclaim", frames = IndexedSeq(8, 9, 10, 11), delay = 0.2, loop = true),
    Animation(id = "yelling", frames = IndexedSeq(8, 9, 10, 11), delay = 0.2, loop = true),
    Animation(id = "crying", frames = IndexedSeq(9, 10, 11), delay = 0.2, loop = true)
  )
)
