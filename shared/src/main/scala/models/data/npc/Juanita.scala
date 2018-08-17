/* Generated File */
package models.data.npc

import models.animation.Animation
import models.npc.TalkItem
import models.template.npc.NpcTemplate

object Juanita extends NpcTemplate(
  key = "juanita",
  name = "Juanita",
  width = 32,
  height = 48,
  greeting = Some("I am {{red_light}}Juanita{{white}}, I live in {{olive}}Tacotown{{white}}."),
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(10, 10, 10, 9), delay = 0.5, loop = true),
    Animation(id = "walking", frames = IndexedSeq(0), delay = 0.2, loop = true)
  ),
  noInventory = None,
  noCommands = None,
  talkItems = Seq[TalkItem](
    TalkItem(prompt = "I am done with you", responses = Nil),
    TalkItem(prompt = "You look very busy", responses = Nil),
    TalkItem(prompt = "Any useful info for me?", responses = List("Items like bone are common around these parts, so they sell for cheap.", "If you want to earn more money, you're better off selling them over at the {{olive}}Forest Town{{white}}.")),
    TalkItem(prompt = "Donde esta...", responses = Nil, children = Seq(
      TalkItem(prompt = "The sandpits?", responses = Nil),
      TalkItem(prompt = "The town mayor?", responses = Nil),
      TalkItem(prompt = "Gay Island?", responses = List("{{olive}}Gay Island{{white}}? Why, it's right across the river from us.", "Of course, no one can even get to them anymore anyways because te exit outta here's blocked off.")),
      TalkItem(prompt = "La biblioteca?", responses = Nil)
    ))
  )
)
