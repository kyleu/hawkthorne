/* Generated File */
package models.data.npc

import models.animation.Animation
import models.npc.TalkItem
import models.template.npc.NpcTemplate

object Hilda extends NpcTemplate(
  key = "hilda",
  name = "Hilda",
  width = 32,
  height = 48,
  greeting = Some("I am {{red_light}}Hilda{{white}}, I live in the {{olive}}village{{white}}."),
  animations = Seq(
    Animation(id = "default", frames = IndexedSeq(0, 10), delay = 0.5, loop = true),
    Animation(id = "walking", frames = IndexedSeq(0, 1, 2), delay = 0.2, loop = true),
    Animation(id = "birth", frames = IndexedSeq(8, 9, 10), delay = 0.5, loop = false),
    Animation(id = "dancing", frames = IndexedSeq(8, 9, 10, 8, 9, 10, 19, 20, 21, 19, 20, 21, 6, 7, 18, 6, 7, 18), delay = 0.15, loop = true),
    Animation(id = "undress", frames = IndexedSeq(0, 8, 9, 10, 11, 10, 9, 8), delay = 0.25, loop = false),
    Animation(id = "fight", frames = IndexedSeq(0, 11), delay = 0.35, loop = false),
    Animation(id = "crying", frames = IndexedSeq(3, 4, 5), delay = 0.25, loop = true),
    Animation(id = "yelling", frames = IndexedSeq(16, 17), delay = 0.5, loop = true),
    Animation(id = "sad", frames = IndexedSeq(16, 17), delay = 0.5, loop = true)
  ),
  noInventory = None,
  noCommands = None,
  talkItems = Seq[TalkItem]( /* TalkItem(prompt = "i am done with you", responses = Nil)
    TalkItem(prompt = "i will wear your skin", responses = Nil)
      ['text']='madam, i am on a quest', ['option']={ (1)
        ['text']='more...', ['option']={ (2)
        TalkItem(prompt = "i am done with you", responses = Nil)
        TalkItem(prompt = "Talk about the Acorn King", responses = Nil)
        TalkItem(prompt = "frog extinction", responses = Nil)
        TalkItem(prompt = "ostrich", responses = Nil)
        TalkItem(prompt = "other parrot", responses = Nil)
        TalkItem(prompt = "anglerfish", responses = Nil)
        TalkItem(prompt = "seal", responses = Nil)
        TalkItem(prompt = "spider", responses = Nil)
        TalkItem(prompt = "snake", responses = Nil)
        TalkItem(prompt = "parrot", responses = Nil)
        TalkItem(prompt = "swordfish", responses = Nil)
        TalkItem(prompt = "rhino", responses = Nil)
        TalkItem(prompt = "magic carpet", responses = Nil)
        TalkItem(prompt = "rocket ship", responses = Nil)
        TalkItem(prompt = "albatross", responses = Nil)
        TalkItem(prompt = "ladder bug", responses = Nil)
        TalkItem(prompt = "hidden pipe", responses = Nil)
        TalkItem(prompt = "subcon vase", responses = Nil)
        TalkItem(prompt = "magic flute", responses = Nil)
        TalkItem(prompt = "star zone", responses = Nil)
        TalkItem(prompt = "rashes", responses = Nil)
        TalkItem(prompt = "zits", responses = Nil)
        TalkItem(prompt = "pimples", responses = Nil)
        TalkItem(prompt = "dark queen", responses = Nil)
        TalkItem(prompt = "mechanical", responses = Nil)
        TalkItem(prompt = "stoneship", responses = Nil)
        TalkItem(prompt = "channel wood", responses = Nil)
        TalkItem(prompt = "space ship", responses = Nil)
        TalkItem(prompt = "old man trainer", responses = Nil)
        TalkItem(prompt = "fly on a bird", responses = Nil)
        TalkItem(prompt = "cinnamon island", responses = Nil)
        TalkItem(prompt = "seal along the shore", responses = Nil)
        TalkItem(prompt = "black lightning", responses = Nil)
        TalkItem(prompt = "hornet", responses = Nil)
        TalkItem(prompt = "shredder", responses = Nil)
        TalkItem(prompt = "avenger", responses = Nil)
        TalkItem(prompt = "wing hat", responses = Nil)
        TalkItem(prompt = "magic feather", responses = Nil)
        TalkItem(prompt = "raccoon clothes", responses = Nil)
        TalkItem(prompt = "running jump", responses = Nil)
        TalkItem(prompt = "collect all blue coins", responses = Nil)
        TalkItem(prompt = "island of annoying voices", responses = Nil)
        TalkItem(prompt = "hot tub end boss", responses = Nil)
        TalkItem(prompt = "mustached mushroom", responses = Nil)
        TalkItem(prompt = "bell toss", responses = Nil)
        TalkItem(prompt = "charged fireball", responses = Nil)
        TalkItem(prompt = "time bombs", responses = Nil)
        TalkItem(prompt = "rock punch", responses = Nil)
        TalkItem(prompt = "blue fire", responses = Nil)
        TalkItem(prompt = "green fire", responses = Nil)
        TalkItem(prompt = "purple fire", responses = Nil)
        TalkItem(prompt = "boring regular old fire", responses = Nil)
        TalkItem(prompt = "flying war ships", responses = Nil)
        TalkItem(prompt = "clown face helicopter", responses = Nil)
        TalkItem(prompt = "teeter totter flying floor", responses = Nil)
        TalkItem(prompt = "unstable bath", responses = Nil)
        TalkItem(prompt = "impervious to lava", responses = Nil)
        TalkItem(prompt = "underwater exploration", responses = Nil)
        TalkItem(prompt = "hover puppy", responses = Nil)
        TalkItem(prompt = "giant ant dance club", responses = Nil)
        TalkItem(prompt = "good karma quests", responses = Nil)
        TalkItem(prompt = "fun quests", responses = Nil)
        TalkItem(prompt = "unkillable bears", responses = Nil)
        TalkItem(prompt = "antiphysics horse", responses = Nil)
        TalkItem(prompt = "bubble attack", responses = Nil)
        TalkItem(prompt = "leaf attack", responses = Nil)
        TalkItem(prompt = "time freeze attack", responses = Nil)
        TalkItem(prompt = "metal blade attack", responses = Nil)
        TalkItem(prompt = "egg treatment", responses = Nil)
        TalkItem(prompt = "blue poultry", responses = Nil)
        TalkItem(prompt = "the chicken lady", responses = Nil)
        TalkItem(prompt = "forest fungus", responses = Nil)
        TalkItem(prompt = "wild children", responses = Nil)
        TalkItem(prompt = "trippy potions", responses = Nil)
        TalkItem(prompt = "pharmacist", responses = Nil)
        TalkItem(prompt = "sawing small trees", responses = Nil)
        TalkItem(prompt = "carpenter camps", responses = Nil)
        TalkItem(prompt = "broken swords", responses = Nil)
        TalkItem(prompt = "giant rock monster", responses = Nil)
        TalkItem(prompt = "frog prescriptions", responses = Nil)
        TalkItem(prompt = "vision medication", responses = Nil)
        TalkItem(prompt = "brick vouchers", responses = Nil)
        TalkItem(prompt = "extra large swords", responses = Nil)
        } (1)
      TalkItem(prompt = "flowers', freeze = true", responses = Nil)
      TalkItem(prompt = "throne of hawkthorne", responses = Nil)
      TalkItem(prompt = "for your hand', freeze = true", responses = Nil)
      } (0) */ )
)
