/* Generated File */
package models.data.npc

import models.animation.Animation
import models.template.npc.NpcTemplate

object Jerry extends NpcTemplate(
  key = "jerry",
  name = "Jerry",
  width = 32,
  height = 48,
  greeting = Some("Hey-oh! I am the janitor around {{olive}}Greendale{{white}}, you can call me {{red_light}}Jerry{{white}}."),
  noInventory = None,
  noCommands = None,
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(0, 10), delay = 0.5, loop = true),
    Animation(id = "walking", frames = IndexedSeq(0, 1, 2), delay = 0.2, loop = true)
  )
)
