/* Generated File */
package models.data.npc

import models.animation.Animation
import models.template.npc.NpcTemplate

object SophieB extends NpcTemplate(
  key = "sophieb",
  name = "SophieB",
  width = 48,
  height = 48,
  greeting = Some("Hello there, I am {{red_light}}Sophie B. Hawkins{{white}}."),
  noInventory = Some("Sorry, my merch guy didn't come along today."),
  noCommands = Some("If you want to hear a song, just ask. But when I'm playing, I'm...Unstoppable!"),
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(0, 0, 0, 0, 0, 0, 0, 0, 1), delay = 0.5, loop = true),
    Animation(id = "playing", frames = IndexedSeq(6, 7, 8, 9, 10, 11), delay = 0.1, loop = true)
  )
)
