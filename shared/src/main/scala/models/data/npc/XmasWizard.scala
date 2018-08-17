/* Generated File */
package models.data.npc

import models.animation.Animation
import models.npc.TalkItem
import models.template.npc.NpcTemplate

object XmasWizard extends NpcTemplate(
  key = "xmaswizard",
  name = "XmasWizard",
  width = 32,
  height = 48,
  greeting = Some("Hello and welcome to {{teal}}Winter Wonderland{{white}}!"),
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(0, 10), delay = 0.5, loop = true),
    Animation(id = "walking", frames = IndexedSeq(0, 1, 2), delay = 0.2, loop = true)
  ),
  noInventory = None,
  noCommands = None,
  talkItems = Seq[TalkItem](
    TalkItem(prompt = "I am done with you", responses = Nil),
    TalkItem(prompt = "How do I get out of here?", responses = List("You must venture to the {{olive}}Cave of Frozen Memories{{white}}", "And there you shall find the exit.")),
    TalkItem(prompt = "Professor Duncan?", responses = List("I do not have the slightest idea", "What you're talking about.")),
    TalkItem(prompt = "Who are you?", responses = List("I am a Christmas Wizard!", "And definitely not a psych professor."))
  )
)
