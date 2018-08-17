/* Generated File */
package models.data.npc

import models.animation.Animation
import models.npc.TalkItem
import models.template.npc.NpcTemplate

object TutorialWizard extends NpcTemplate(
  key = "tutorial_wizard",
  name = "TutorialWizard",
  width = 32,
  height = 48,
  greeting = Some("Hello and welcome to {{teal}}The Test Level{{white}}!"),
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(0, 10), delay = 0.5, loop = true),
    Animation(id = "walking", frames = IndexedSeq(0, 1, 2), delay = 0.2, loop = true)
  ),
  noInventory = None,
  noCommands = None,
  talkItems = Seq[TalkItem](
    TalkItem(prompt = "I am done with you", responses = Nil),
    TalkItem(prompt = "Where are the tutorials?", responses = List("I'm a tutorial wizard not a tutorial conjurer.")),
    TalkItem(prompt = "Professor Duncan?", responses = List("I do not have the slightest idea", "What you're talking about.")),
    TalkItem(prompt = "Who are you?", responses = List("I am a Tutorial Wizard!", "And definitely not a Christmas Wizard."))
  )
)
