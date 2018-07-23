/* Generated File */
package models.data.npc

import models.animation.Animation
import models.template.npc.NpcTemplate

object Hilda extends NpcTemplate(
  key = "hilda",
  name = "Hilda",
  width = 32,
  height = 48,
  greeting = Some("I am {{red_light}}Hilda{{white}}, I live in the {{olive}}village{{white}}."),
  noInventory = None,
  noCommands = None,
  animations = Seq(
    Animation(id = "default.", frames = IndexedSeq(0, 10), delay = 0.5, loop = true),
    Animation(id = "walking.", frames = IndexedSeq(0, 1, 2), delay = 0.2, loop = true),
    Animation(id = "birth.", frames = IndexedSeq(8, 9, 10), delay = 0.5, loop = false),
    Animation(id = "dancing.", frames = IndexedSeq(8, 9, 10, 8, 9, 10, 19, 20, 21, 19, 20, 21, 6, 7, 18, 6, 7, 18), delay = 0.15, loop = true),
    Animation(id = "undress.", frames = IndexedSeq(0, 8, 9, 10, 11, 10, 9, 8), delay = 0.25, loop = false),
    Animation(id = "fight.", frames = IndexedSeq(0, 11), delay = 0.35, loop = false),
    Animation(id = "crying.", frames = IndexedSeq(3, 4, 5), delay = 0.25, loop = true),
    Animation(id = "yelling.", frames = IndexedSeq(16, 17), delay = 0.5, loop = true),
    Animation(id = "sad.", frames = IndexedSeq(16, 17), delay = 0.5, loop = true)
  )
)
