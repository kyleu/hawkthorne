/* Generated File */
package models.data.npc

import models.animation.Animation
import models.template.npc.NpcTemplate

object MayorJuan extends NpcTemplate(
  key = "mayorjuan",
  name = "MayorJuan",
  width = 48,
  height = 48,
  greeting = Some("My name is {{red_light}}Juan{{white}}, I am the mayor of {{olive}}Tacotown{{white}}."),
  noInventory = None,
  noCommands = None,
  animations = Seq(
    Animation(id = "default.", frames = IndexedSeq(0, 1), delay = 0.4, loop = true)
  )
)
