/* Generated File */
package models.data.enemy

import models.animation.Animation
import models.template.enemy.EnemyTemplate

object LaserLotusBoss extends EnemyTemplate(
  key = "laserlotusBoss",
  name = "LaserLotusBoss",
  width = 48,
  height = 48,
  hp = 50,
  damage = 20,
  isBoss = true,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = None,
  sounds = Seq.empty,
  animations = Seq(
    Animation(id = "attack.right", frames = IndexedSeq(3, 4, 3, 5), delay = 0.25, loop = true),
    Animation(id = "attack.left", frames = IndexedSeq(15, 14, 15, 13), delay = 0.25, loop = true),
    Animation(id = "default.right", frames = IndexedSeq(3, 4, 3, 5), delay = 0.25, loop = true),
    Animation(id = "default.left", frames = IndexedSeq(15, 14, 15, 13), delay = 0.25, loop = true),
    Animation(id = "enter.right", frames = IndexedSeq(0), delay = 0.25, loop = false),
    Animation(id = "enter.left", frames = IndexedSeq(21), delay = 0.25, loop = false),
    Animation(id = "hurt.right", frames = IndexedSeq(9), delay = 0.4, loop = false),
    Animation(id = "hurt.left", frames = IndexedSeq(3), delay = 0.4, loop = false),
    Animation(id = "castlaser.right", frames = IndexedSeq(6, 7, 8, 7), delay = 0.25, loop = true),
    Animation(id = "castlaser.left", frames = IndexedSeq(9, 8, 7, 8), delay = 0.25, loop = true),
    Animation(id = "dying.right", frames = IndexedSeq(10, 10, 10, 11, 12, 13), delay = 0.25, loop = false),
    Animation(id = "dying.left", frames = IndexedSeq(14, 14, 14, 27, 26, 25), delay = 0.25, loop = false),
    Animation(id = "vanish.right", frames = IndexedSeq(11, 12, 13), delay = 0.2, loop = false),
    Animation(id = "vanish.left", frames = IndexedSeq(27, 26, 25), delay = 0.2, loop = false)
  )
)
