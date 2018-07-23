/* Generated File */
package models.data.enemy

import models.animation.Animation
import models.template.enemy.EnemyTemplate

object TurkeyBoss extends EnemyTemplate(
  key = "turkeyBoss",
  name = "TurkeyBoss",
  width = 215,
  height = 115,
  hp = 100,
  damage = 40,
  isBoss = true,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = None,
  sounds = Seq.empty,
  animations = Seq(
    Animation(id = "jump.right", frames = IndexedSeq(6, 7), delay = 0.25, loop = true),
    Animation(id = "jump.left", frames = IndexedSeq(10, 11), delay = 0.25, loop = true),
    Animation(id = "attack.right", frames = IndexedSeq(7), delay = 0.2, loop = false),
    Animation(id = "attack.left", frames = IndexedSeq(11), delay = 0.2, loop = false),
    Animation(id = "charge.right", frames = IndexedSeq(3), delay = 0.8, loop = false),
    Animation(id = "charge.left", frames = IndexedSeq(15), delay = 0.8, loop = false),
    Animation(id = "default.right", frames = IndexedSeq(2, 3), delay = 0.25, loop = true),
    Animation(id = "default.left", frames = IndexedSeq(4, 5), delay = 0.25, loop = true),
    Animation(id = "hurt.right", frames = IndexedSeq(2, 3), delay = 0.25, loop = true),
    Animation(id = "hurt.left", frames = IndexedSeq(4, 5), delay = 0.25, loop = true),
    Animation(id = "dying.right", frames = IndexedSeq(4, 5, 6, 7), delay = 0.25, loop = false),
    Animation(id = "dying.left", frames = IndexedSeq(8, 9, 10, 11), delay = 0.25, loop = false),
    Animation(id = "enter.right", frames = IndexedSeq(4), delay = 0.25, loop = false),
    Animation(id = "enter.left", frames = IndexedSeq(4), delay = 0.25, loop = false),
    Animation(id = "hatch.right", frames = IndexedSeq(13, 14, 0, 1, 2), delay = 0.25, loop = false),
    Animation(id = "hatch.left", frames = IndexedSeq(13, 14, 0, 1, 2), delay = 0.25, loop = false)
  )
)
