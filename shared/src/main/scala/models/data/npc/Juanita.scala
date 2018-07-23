/* Generated File */
package models.data.npc

import models.animation.Animation
import models.template.npc.NpcTemplate

object Juanita extends NpcTemplate(
  key = "juanita",
  name = "Juanita",
  width = 32,
  height = 48,
  greeting = Some("I am {{red_light}}Juanita{{white}}, I live in {{olive}}Tacotown{{white}}."),
  noInventory = None,
  noCommands = None,
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(10, 10, 10, 9), delay = 0.5, loop = true),
    Animation(id = "walking", frames = IndexedSeq(0), delay = 0.2, loop = true)
  )
)
