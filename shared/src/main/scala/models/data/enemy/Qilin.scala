/* Generated File */
package models.data.enemy

import models.animation.Animation
import models.template.enemy.EnemyTemplate

object Qilin extends EnemyTemplate(
  key = "qilin",
  name = "Qilin",
  width = 72,
  height = 58,
  hp = 25,
  damage = 30,
  isBoss = false,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = Some("manicorn_neigh"),
  sounds = Seq.empty,
  animations = Seq(
    Animation(id = "default.left", frames = IndexedSeq(0, 1), delay = 0.2, loop = true),
    Animation(id = "default.right", frames = IndexedSeq(2, 3), delay = 0.2, loop = true),
    Animation(id = "hurt.left", frames = IndexedSeq(0, 1), delay = 0.2, loop = true),
    Animation(id = "hurt.right", frames = IndexedSeq(2, 3), delay = 0.2, loop = true),
    Animation(id = "attack.left", frames = IndexedSeq(2, 3, 4), delay = 0.2, loop = true),
    Animation(id = "attack.right", frames = IndexedSeq(7, 8, 9), delay = 0.2, loop = true),
    Animation(id = "hurt.left", frames = IndexedSeq(5), delay = 0.4, loop = false),
    Animation(id = "hurt.right", frames = IndexedSeq(11), delay = 0.4, loop = false),
    Animation(id = "dying.left", frames = IndexedSeq(6, 7), delay = 0.4, loop = false),
    Animation(id = "dying.right", frames = IndexedSeq(14, 15), delay = 0.4, loop = false)
  )
)
