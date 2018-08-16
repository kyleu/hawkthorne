/* Generated File */
package models.data.npc

import models.animation.Animation
import models.npc.TalkItem
import models.template.npc.NpcTemplate

object ProfHolly extends NpcTemplate(
  key = "profholly",
  name = "ProfHolly",
  width = 32,
  height = 48,
  greeting = Some("Hello, my precious blueberry! You can call me {{red_light}}Professor Holly{{white}}."),
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(0, 10), delay = 0.5, loop = true),
    Animation(id = "walking", frames = IndexedSeq(0, 1, 2), delay = 0.2, loop = true)
  ),
  noInventory = Some("Sorry, blueberry. All I have is on the shelves!"),
  noCommands = Some("Command is such a strong, ugly word."),
  talkItems = Seq[TalkItem]( /* TalkItem(prompt = "i am done with you", responses = Nil)
      ['text']='No Ghosting, huh?', ['option']={ (1)
      TalkItem(prompt = "A long lonely tiiiiime", responses = Nil)
      TalkItem(prompt = "Hungered for your touch", responses = Nil)
      TalkItem(prompt = "My darling...", responses = Nil)
      TalkItem(prompt = "Oh, my love...", responses = Nil)
      } (0)
    TalkItem(prompt = "How to get an art credit.", responses = Nil) */ )
)
