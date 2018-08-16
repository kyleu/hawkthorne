/* Generated File */
package models.data.npc

import models.animation.Animation
import models.npc.TalkItem
import models.template.npc.NpcTemplate

object GayNpc extends NpcTemplate(
  key = "gaynpc",
  name = "GayNpc",
  width = 32,
  height = 48,
  greeting = Some("Heeeyyyyyyyy-o, my name is {{red_light}}Fenton{{white}}!"),
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(0, 10), delay = 0.5, loop = true),
    Animation(id = "walking", frames = IndexedSeq(0, 1, 2), delay = 0.2, loop = true)
  ),
  noInventory = None,
  noCommands = None,
  talkItems = Seq[TalkItem]( /* TalkItem(prompt = "i am done with you", responses = Nil)
    TalkItem(prompt = "Any useful info for me?", responses = Nil)
    TalkItem(prompt = "What kind of place is this?", responses = Nil) */ )
)
