/* Generated File */
package models.data.npc

import models.animation.Animation
import models.npc.TalkItem
import models.template.npc.NpcTemplate

object MayorJuan extends NpcTemplate(
  key = "mayorjuan",
  name = "MayorJuan",
  width = 48,
  height = 48,
  greeting = Some("My name is {{red_light}}Juan{{white}}, I am the mayor of {{olive}}Tacotown{{white}}."),
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(0, 1), delay = 0.4, loop = true)
  ),
  noInventory = None,
  noCommands = None,
  talkItems = Seq[TalkItem](
    TalkItem(prompt = "I am done with you", responses = Nil),
    TalkItem(prompt = "Sick moustache!", responses = List("Why, thank you so much!", "I am very proud of my moustache, I comb it 20 times a day.")),
    TalkItem(prompt = "Donde esta...", responses = Nil, children = Seq(
      TalkItem(prompt = "The sandpits?", responses = Nil),
      TalkItem(prompt = "The town hall?", responses = Nil),
      TalkItem(prompt = "The chili fields?", responses = Nil),
      TalkItem(prompt = "La biblioteca?", responses = Nil)
    )),
    TalkItem(prompt = "So you are the mayor?", responses = Nil, children = Seq(
      TalkItem(prompt = "Why is the exit blocked?", responses = List("That was not my doing, I can assure you that.", "It was that madman {{grey}}Cornelius{{white}}. He and his goons set that up to prevent anybody from exiting the valley.")),
      TalkItem(prompt = "Why is the town so dirty?", responses = List("Pfft, this is a clean enough town.", "I'm a busy, busy man, I've got better things to do than pick up litter.")),
      TalkItem(prompt = "Tell me about this place", responses = List("What is there to tell? Our town boasts the finest tacos in the world.", "It used to be a hub of festivals and siestas before that madman {{grey}}Cornelius{{white}} took over.", "If only someone were to kick him off that throne...")),
      TalkItem(prompt = "How do I get out of here?", responses = List("The only way out of the Valley is back where you came from, to the forests.", "If you're going to continue on to {{olive}}Gay Island{{white}}, you gotta go through the sandpits.", "The sandpits were used way back as a secret entrance, but we abandoned it when it was infested by giant spiders."))
    ))
  )
)
