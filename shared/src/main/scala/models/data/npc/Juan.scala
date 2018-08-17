/* Generated File */
package models.data.npc

import models.animation.Animation
import models.npc.TalkItem
import models.template.npc.NpcTemplate

object Juan extends NpcTemplate(
  key = "juan1",
  name = "Juan",
  width = 32,
  height = 48,
  greeting = Some("My name is {{red_light}}Juan{{white}}, I spend my days lazying around {{olive}}Tacotown{{white}}."),
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(0, 10), delay = 0.5, loop = true),
    Animation(id = "walking", frames = IndexedSeq(0, 1, 2), delay = 0.2, loop = true)
  ),
  noInventory = None,
  noCommands = None,
  talkItems = Seq[TalkItem](
    TalkItem(prompt = "I am done with you", responses = Nil),
    TalkItem(prompt = "More options...", responses = Nil, children = Seq(
      TalkItem(prompt = "Lay off that booze, pal", responses = List("Buzz off, guy. You're not my mother.", "Besides, I'm only on my 6th bottle of the day.")),
      TalkItem(prompt = "You own that goat farm?", responses = Nil),
      TalkItem(prompt = "Tell me about this place", responses = List("This stinkhole of a town? Nothing much to tell.", "There's {{red_light}}Senor Juan{{white}} and his goons guarding the passage out of the valley...", "Not that anyone's had a good reason to try and leave.")),
      TalkItem(prompt = "I could sure use a beer", responses = List("Well, you ain't getting any of mine."))
    )),
    TalkItem(prompt = "Any useful info for me?", responses = List("If you're thinking about going into the {{olive}}sandpits{{white}}, it would be a good idea to bring a weapon.", "I hear the ceiling is so low you can't even jump on enemies to hurt them.")),
    TalkItem(prompt = "Donde esta...", responses = Nil, children = Seq(
      TalkItem(prompt = "Castle Hawkthorne?", responses = List("I really hope you're not thinking of going there, that's a pretty darn dangrous place.", "That being said, the castle is {{red_dark}}northeast{{white}} of here, past {{olive}}Gay Island{{white}} and the {{olive}}Black Caverns{{white}}.")),
      TalkItem(prompt = "The town blacksmith?", responses = Nil),
      TalkItem(prompt = "The sandpits?", responses = Nil),
      TalkItem(prompt = "La biblioteca?", responses = Nil)
    ))
  )
)
