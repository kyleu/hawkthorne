/* Generated File */
package models.data.enemy

import models.animation.Animation
import models.template.enemy.EnemyTemplate

object Monkey extends EnemyTemplate(
  key = "monkey",
  name = "Monkey",
  width = 23,
  height = 29,
  hp = 1,
  damage = 0,
  isBoss = false,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = None,
  sounds = Seq.empty,
  animations = Seq(
    Animation(id = "dying.right", frames = IndexedSeq(5), delay = 1.0, loop = false),
    Animation(id = "dying.left", frames = IndexedSeq(11), delay = 1.0, loop = false),
    Animation(id = "default.right", frames = IndexedSeq(0, 2, 1, 2), delay = 0.25, loop = true),
    Animation(id = "default.left", frames = IndexedSeq(1, 5, 3, 5), delay = 0.25, loop = true),
    Animation(id = "hurt.right", frames = IndexedSeq(0, 2, 1, 2), delay = 0.25, loop = true),
    Animation(id = "hurt.left", frames = IndexedSeq(1, 5, 3, 5), delay = 0.25, loop = true)
  )
)
