/* Generated File */
package models.data.npc

import models.animation.Animation
import models.npc.TalkItem
import models.template.npc.NpcTemplate

object SenorJuan extends NpcTemplate(
  key = "senorjuan",
  name = "SenorJuan",
  width = 32,
  height = 48,
  greeting = Some("My name is {{red_light}}Senor Juan{{white}}. I guard this {{orange}}fence{{white}}."),
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(0, 10), delay = 0.5, loop = true),
    Animation(id = "walking", frames = IndexedSeq(0, 1, 2), delay = 0.2, loop = true)
  ),
  noInventory = None,
  noCommands = None,
  talkItems = Seq[TalkItem](
    TalkItem(prompt = "Where\'s your hat?", responses = Nil),
    TalkItem(prompt = "Who are you?", responses = List("I am Senor Juan, the lead border guard in charge of making sure no one gets out of this Valley.")),
    TalkItem(prompt = "Is there another way out?", responses = List("Right now? Of course not, son, otherwise everybody would have escaped by now.", "I heard some villagers talk about a secret tunnel underground called the {{olive}}Sandpits{{white}} that was used to smuggle, ah, questionable substances out of here.", "That was a long time ago though, I hear it's now infested with giant, deadly spiders. You should ask the villagers if you want to know more.")),
    TalkItem(prompt = "Tell me about this fence", responses = Nil, children = Seq(
      TalkItem(prompt = "Who put this here?", responses = List("That old king {{grey}}Cornelius{{white}} put this thing up here not too long ago, and hired me and my crew to help build and guard it.")),
      TalkItem(prompt = "Why is this here?", responses = List("When his majesty {{grey}}Cornelius{{white}} got tired of all the illegal immigrants pouring out, he commissioned the construction of this fence.", "That, and because of the amount of illegal substances secretly being smuggled out of here.")),
      TalkItem(prompt = "Can I pass?", responses = List("Hah, you're welcome to try. There's no possible way you can jump over this thing.", "Don't even think about trying to break it either, it's reinforced with triple-thick steel.")),
      TalkItem(prompt = "Why are you guarding it?", responses = List("I was hired, to help build and guard this thing.", "Some people call me a traitor to the Valley villagers, but hey, money's money."))
    ))
  )
)
