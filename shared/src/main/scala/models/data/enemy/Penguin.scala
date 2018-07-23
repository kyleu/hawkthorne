/* Generated File */
package models.data.enemy

import models.animation.Animation
import models.template.enemy.EnemyTemplate

object Penguin extends EnemyTemplate(
  key = "penguin",
  name = "Penguin",
  width = 40,
  height = 20,
  hp = 1,
  damage = 0,
  isBoss = false,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = Some("acorn_crush"),
  sounds = Seq.empty,
  animations = Seq(
    Animation(id = "dying.right", frames = IndexedSeq(3), delay = 0.25, loop = false),
    Animation(id = "dying.left", frames = IndexedSeq(7), delay = 0.25, loop = false),
    Animation(id = "default.right", frames = IndexedSeq(1, 2), delay = 0.25, loop = true),
    Animation(id = "default.left", frames = IndexedSeq(3, 5), delay = 0.25, loop = true),
    Animation(id = "hurt.right", frames = IndexedSeq(1, 2), delay = 0.25, loop = true),
    Animation(id = "hurt.left", frames = IndexedSeq(3, 5), delay = 0.25, loop = true)
  )
)
