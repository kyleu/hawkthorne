/* Generated File */
package models.data.enemy

import models.animation.Animation
import models.template.enemy.EnemyTemplate

object Bird extends EnemyTemplate(
  key = "bird",
  name = "Bird",
  width = 32,
  height = 32,
  hp = 6,
  damage = 10,
  isBoss = false,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = None,
  sounds = Seq.empty,
  animations = Seq(
    Animation(id = "default.left", frames = IndexedSeq(4, 5, 6, 7), delay = 0.25, loop = true),
    Animation(id = "default.right", frames = IndexedSeq(0, 1, 2, 3), delay = 0.25, loop = true),
    Animation(id = "hurt.left", frames = IndexedSeq(9), delay = 0.25, loop = false),
    Animation(id = "hurt.right", frames = IndexedSeq(4), delay = 0.25, loop = false),
    Animation(id = "dying.left", frames = IndexedSeq(9), delay = 0.25, loop = false),
    Animation(id = "dying.right", frames = IndexedSeq(4), delay = 0.25, loop = false),
    Animation(id = "attack.left", frames = IndexedSeq(4, 5, 6, 7), delay = 0.25, loop = true),
    Animation(id = "attack.right", frames = IndexedSeq(0, 1, 2, 3), delay = 0.25, loop = true)
  )
)
