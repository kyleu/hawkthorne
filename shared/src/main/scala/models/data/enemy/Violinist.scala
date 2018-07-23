/* Generated File */
package models.data.enemy

import models.animation.Animation
import models.template.enemy.EnemyTemplate

object Violinist extends EnemyTemplate(
  key = "violinist",
  name = "Violinist",
  width = 48,
  height = 48,
  hp = 12,
  damage = 20,
  isBoss = false,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = Some("trombone_temp"),
  sounds = Seq.empty,
  animations = Seq(
    Animation(id = "dying.right", frames = IndexedSeq(12, 13, 14, 15), delay = 0.25, loop = true),
    Animation(id = "dying.left", frames = IndexedSeq(4, 5, 6, 7), delay = 0.25, loop = true),
    Animation(id = "default.right", frames = IndexedSeq(12, 13, 14, 15), delay = 0.25, loop = true),
    Animation(id = "default.left", frames = IndexedSeq(4, 5, 6, 7), delay = 0.25, loop = true),
    Animation(id = "hurt.right", frames = IndexedSeq(12, 13, 14, 15), delay = 0.25, loop = true),
    Animation(id = "hurt.left", frames = IndexedSeq(4, 5, 6, 7), delay = 0.25, loop = true),
    Animation(id = "dying.right", frames = IndexedSeq(12, 13, 14, 15), delay = 0.25, loop = true),
    Animation(id = "dying.left", frames = IndexedSeq(4, 5, 6, 7), delay = 0.25, loop = true),
    Animation(id = "attack.right", frames = IndexedSeq(20, 21, 22, 23), delay = 0.1, loop = true),
    Animation(id = "attack.left", frames = IndexedSeq(8, 9, 10, 11), delay = 0.1, loop = true),
    Animation(id = "dashattack.right", frames = IndexedSeq(22, 23, 24), delay = 0.1, loop = true),
    Animation(id = "dashattack.left", frames = IndexedSeq(17, 18, 19), delay = 0.1, loop = true)
  )
)
