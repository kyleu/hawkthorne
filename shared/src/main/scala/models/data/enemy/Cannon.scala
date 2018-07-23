/* Generated File */
package models.data.enemy

import models.animation.Animation
import models.template.enemy.EnemyTemplate

object Cannon extends EnemyTemplate(
  key = "cannon",
  name = "Cannon",
  width = 24,
  height = 13,
  hp = 5,
  damage = 0,
  isBoss = false,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = None,
  sounds = Seq.empty,
  animations = Seq(
    Animation(id = "dying.right", frames = IndexedSeq(0), delay = 0.25, loop = false),
    Animation(id = "dying.left", frames = IndexedSeq(0), delay = 0.25, loop = false),
    Animation(id = "default.right", frames = IndexedSeq(0), delay = 0.25, loop = false),
    Animation(id = "default.left", frames = IndexedSeq(0), delay = 0.25, loop = false),
    Animation(id = "hurt.right", frames = IndexedSeq(0), delay = 0.25, loop = false),
    Animation(id = "hurt.left", frames = IndexedSeq(0), delay = 0.25, loop = false),
    Animation(id = "attack.right", frames = IndexedSeq(0), delay = 0.25, loop = false),
    Animation(id = "attack.left", frames = IndexedSeq(0), delay = 0.25, loop = false),
    Animation(id = "attackranged.left", frames = IndexedSeq(0, 1, 2), delay = 0.25, loop = true),
    Animation(id = "attackranged.right", frames = IndexedSeq(0, 1, 2), delay = 0.25, loop = true)
  )
)
