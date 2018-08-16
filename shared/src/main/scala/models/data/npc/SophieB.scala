/* Generated File */
package models.data.npc

import models.animation.Animation
import models.npc.TalkItem
import models.template.npc.NpcTemplate

object SophieB extends NpcTemplate(
  key = "sophieb",
  name = "SophieB",
  width = 48,
  height = 48,
  greeting = Some("Hello there, I am {{red_light}}Sophie B. Hawkins{{white}}."),
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(0, 0, 0, 0, 0, 0, 0, 0, 1), delay = 0.5, loop = true),
    Animation(id = "playing", frames = IndexedSeq(6, 7, 8, 9, 10, 11), delay = 0.1, loop = true)
  ),
  noInventory = Some("Sorry, my merch guy didn't come along today."),
  noCommands = Some("If you want to hear a song, just ask. But when I'm playing, I'm...Unstoppable!"),
  talkItems = Seq[TalkItem]( /* TalkItem(prompt = "i am done with you", responses = Nil)
      ['text']='Can you play me...', ['option']={ (1)
      TalkItem(prompt = "Where I Belong", responses = Nil)
      TalkItem(prompt = "What Christmas Is For", responses = Nil)
      TalkItem(prompt = "Viva Tacotown!", responses = Nil)
      TalkItem(prompt = "Village Forest", responses = Nil)
      TalkItem(prompt = "Valley of Laziness", responses = Nil)
      TalkItem(prompt = "Starting The Game", responses = Nil)
      TalkItem(prompt = "Somewhere Out There", responses = Nil)
      TalkItem(prompt = "Seabluff", responses = Nil)
      TalkItem(prompt = "Pocketful of Hawthornes", responses = Nil)
      TalkItem(prompt = "Overworld", responses = Nil)
      TalkItem(prompt = "New Abedtown", responses = Nil)
      TalkItem(prompt = "M.A.S.H. Theme", responses = Nil)
      TalkItem(prompt = "Mamma Mia", responses = Nil)
      TalkItem(prompt = "Love So Alike", responses = Nil)
      TalkItem(prompt = "Lets Play Poker", responses = Nil)
      TalkItem(prompt = "Lazy Sandpits", responses = Nil)
      TalkItem(prompt = "Kiss From A Rose", responses = Nil)
      TalkItem(prompt = "Hall O Hippies", responses = Nil)
      TalkItem(prompt = "Greendale Rave", responses = Nil)
      TalkItem(prompt = "Greendale Hallways", responses = Nil)
      TalkItem(prompt = "Greendale Exterior", responses = Nil)
      TalkItem(prompt = "Mountains", responses = Nil)
      TalkItem(prompt = "Forest", responses = Nil)
      TalkItem(prompt = "Farewell Abed", responses = Nil)
      TalkItem(prompt = "Enter Cornelius", responses = Nil)
      TalkItem(prompt = "Daybreak", responses = Nil)
      TalkItem(prompt = "Comfy At A Cauldron", responses = Nil)
      TalkItem(prompt = "Castle Interior", responses = Nil)
      TalkItem(prompt = "Castle Exterior", responses = Nil)
      TalkItem(prompt = "Blacksmiths House", responses = Nil)
      TalkItem(prompt = "Black Caverns", responses = Nil)
      TalkItem(prompt = "Alas Poor Britta-Bot", responses = Nil)
      TalkItem(prompt = "A Girl Milking A Cow", responses = Nil)
      TalkItem(prompt = "Abeds Christmas Medley", responses = Nil)
      TalkItem(prompt = "Abeds Castle", responses = Nil)
      } (0)
    TalkItem(prompt = "I missed the dance...", responses = Nil) */ )
)
