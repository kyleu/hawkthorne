/* Generated File */
package models.data.npc

import models.animation.Animation
import models.template.npc.NpcTemplate

object ProfHolly extends NpcTemplate(
  key = "profholly",
  name = "ProfHolly",
  width = 32,
  height = 48,
  greeting = Some("Hello, my precious blueberry! You can call me {{red_light}}Professor Holly{{white}}."),
  noInventory = Some("Sorry, blueberry. All I have is on the shelves!"),
  noCommands = Some("Command is such a strong, ugly word."),
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(0, 10), delay = 0.5, loop = true),
    Animation(id = "walking", frames = IndexedSeq(0, 1, 2), delay = 0.2, loop = true)
  )
)
