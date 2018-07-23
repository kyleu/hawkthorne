/* Generated File */
package models.data.enemy

import models.animation.Animation
import models.template.enemy.EnemyTemplate

object Ducky extends EnemyTemplate(
  key = "ducky",
  name = "Ducky",
  width = 30,
  height = 30,
  hp = 8,
  damage = 20,
  isBoss = false,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = Some("duckysqueak"),
  sounds = Seq.empty,
  animations = Seq(
    Animation(id = "default.left", frames = IndexedSeq(0, 1), delay = 0.25, loop = true),
    Animation(id = "default.right", frames = IndexedSeq(2, 3), delay = 0.25, loop = true),
    Animation(id = "jump.left", frames = IndexedSeq(2), delay = 1.0, loop = false),
    Animation(id = "jump.right", frames = IndexedSeq(3), delay = 1.0, loop = false),
    Animation(id = "attack.left", frames = IndexedSeq(8, 9, 10, 11), delay = 0.2, loop = true),
    Animation(id = "attack.right", frames = IndexedSeq(12, 13, 14, 15), delay = 0.2, loop = true),
    Animation(id = "hurt.left", frames = IndexedSeq(4), delay = 0.4, loop = true),
    Animation(id = "hurt.right", frames = IndexedSeq(5), delay = 0.4, loop = true),
    Animation(id = "dying.left", frames = IndexedSeq(6), delay = 0.4, loop = false),
    Animation(id = "dying.right", frames = IndexedSeq(7), delay = 0.4, loop = false)
  )
)
