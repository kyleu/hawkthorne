/* Generated File */
package models.data.npc

import models.npc.NpcTemplate

object SophieB extends NpcTemplate(
  key = "sophieb",
  name = "SophieB",
  width = 48,
  height = 48,
  greeting = Some("Hello there, I am {{red_light}}Sophie B. Hawkins{{white}}."),
  noInventory = Some("Sorry, my merch guy didn't come along today."),
  noCommands = Some("If you want to hear a song, just ask. But when I'm playing, I'm...Unstoppable!"),
  animations = Seq.empty
)
