/* Generated File */
package models.data.npc

import models.animation.Animation
import models.npc.TalkItem
import models.template.npc.NpcTemplate

object Tilda extends NpcTemplate(
  key = "tilda",
  name = "Tilda",
  width = 32,
  height = 48,
  greeting = None,
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(0, 10), delay = 0.5, loop = true),
    Animation(id = "walking", frames = IndexedSeq(0, 1, 2), delay = 0.2, loop = true)
  ),
  noInventory = None,
  noCommands = None,
  talkItems = Seq[TalkItem](
    TalkItem(prompt = "I am done with you", responses = Nil),
    TalkItem(prompt = "You look familiar...", responses = List("My name is Tilda, I used to live in the village.", "When I was forced into marrying a man I did not love, I fled deep into these woods and now I fend for myself in the winderness.", "You may have met my sister, Hilda. She and I resemble each other greatly.")),
    TalkItem(prompt = "Any useful info for me?", responses = List("Watch out for those acorns, traveler! They are small, but can be quite aggressive when attacked.")),
    TalkItem(prompt = "Talk about quests", responses = Nil)
  )
)
