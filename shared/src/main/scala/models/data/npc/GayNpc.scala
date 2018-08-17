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
  talkItems = Seq[TalkItem](
    TalkItem(prompt = "I am done with you", responses = Nil),
    TalkItem(prompt = "Any useful info for me?", responses = List("Uh-huh, for one, you should never wear those hideous colors together.", "That's a crime, that's what it is, the way you're wearing those rags.")),
    TalkItem(prompt = "What kind of place is this?", responses = List("This place is FABULOUS!", "It's called {{olive}}Gay Island{{white}}, home of the free and the fashionable.")),
    TalkItem(prompt = "Hello!", responses = List("Heeeyyyyyyyy-o", "Gurl, today is a fab-tastic day."))
  )
)
