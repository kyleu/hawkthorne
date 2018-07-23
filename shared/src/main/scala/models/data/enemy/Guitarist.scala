/* Generated File */
package models.data.enemy

import models.animation.Animation
import models.template.enemy.EnemyTemplate

object Guitarist extends EnemyTemplate(
  key = "guitarist",
  name = "Guitarist",
  width = 48,
  height = 48,
  hp = 16,
  damage = 30,
  isBoss = false,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = Some("trombone_temp"),
  sounds = Seq.empty,
  animations = Seq(
    Animation(id = "dying.right", frames = IndexedSeq(12, 13, 14, 15), delay = 0.25, loop = true),
    Animation(id = "dying.left", frames = IndexedSeq(4, 5, 6, 7), delay = 0.25, loop = true),
    Animation(id = "default.right", frames = IndexedSeq(12, 13, 14, 15), delay = 0.2, loop = true),
    Animation(id = "default.left", frames = IndexedSeq(4, 5, 6, 7), delay = 0.2, loop = true),
    Animation(id = "hurt.right", frames = IndexedSeq(12, 13, 14, 15), delay = 0.2, loop = true),
    Animation(id = "hurt.left", frames = IndexedSeq(4, 5, 6, 7), delay = 0.2, loop = true),
    Animation(id = "dying.right", frames = IndexedSeq(12, 13, 14, 15), delay = 0.2, loop = true),
    Animation(id = "dying.left", frames = IndexedSeq(4, 5, 6, 7), delay = 0.2, loop = true),
    Animation(id = "attack.right", frames = IndexedSeq(12, 13, 14, 15), delay = 0.2, loop = true),
    Animation(id = "attack.left", frames = IndexedSeq(4, 5, 6, 7), delay = 0.2, loop = true),
    Animation(id = "pushattack.right", frames = IndexedSeq(18, 19, 20), delay = 0.2, loop = true),
    Animation(id = "pushattack.left", frames = IndexedSeq(9, 10, 11), delay = 0.2, loop = true)
  )
)
