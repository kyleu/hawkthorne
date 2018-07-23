/* Generated File */
package models.data.enemy

import models.animation.Animation
import models.template.enemy.EnemyTemplate

object Hemp extends EnemyTemplate(
  key = "hemp",
  name = "Hemp",
  width = 48,
  height = 48,
  hp = 1,
  damage = 20,
  isBoss = false,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = Some("hemp"),
  sounds = Seq.empty,
  animations = Seq(
    Animation(id = "default.right", frames = IndexedSeq(0, 1, 2, 3, 4, 5, 6, 7), delay = 0.2, loop = true),
    Animation(id = "default.left", frames = IndexedSeq(0, 1, 2, 3, 4, 5, 6, 7), delay = 0.2, loop = true),
    Animation(id = "dying.right", frames = IndexedSeq(8, 9), delay = 0.1, loop = false),
    Animation(id = "dying.left", frames = IndexedSeq(8, 9), delay = 0.1, loop = false),
    Animation(id = "hurt.right", frames = IndexedSeq(8, 9), delay = 0.1, loop = false),
    Animation(id = "hurt.left", frames = IndexedSeq(8, 9), delay = 0.1, loop = false)
  )
)
