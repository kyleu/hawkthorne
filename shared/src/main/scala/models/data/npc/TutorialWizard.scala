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
  talkItems = Seq[TalkItem]( /* TalkItem(prompt = "i am done with you", responses = Nil)
    TalkItem(prompt = "Where are the tutorials?", responses = Nil)
    TalkItem(prompt = "Professor Duncan?", responses = Nil)
    TalkItem(prompt = "Who are you?", responses = Nil) */ )
)
