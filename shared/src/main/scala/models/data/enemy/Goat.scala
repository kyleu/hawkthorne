/* Generated File */
package models.data.enemy

import models.animation.Animation
import models.template.enemy.EnemyTemplate

object Goat extends EnemyTemplate(
  key = "goat",
  name = "Goat",
  width = 48,
  height = 48,
  hp = 1,
  damage = 0,
  isBoss = false,
  passiveSound = Some("goat"),
  attackSounds = Nil,
  dieSound = Some("goat"),
  sounds = Seq.empty,
  animations = Seq(
    Animation(id = "default.right", frames = IndexedSeq(4, 5, 6, 7), delay = 0.25, loop = true),
    Animation(id = "default.left", frames = IndexedSeq(0, 1, 2, 3), delay = 0.25, loop = true),
    Animation(id = "dying.right", frames = IndexedSeq(9), delay = 0.25, loop = true),
    Animation(id = "dying.left", frames = IndexedSeq(4), delay = 0.25, loop = true),
    Animation(id = "hurt.right", frames = IndexedSeq(9), delay = 0.25, loop = true),
    Animation(id = "hurt.left", frames = IndexedSeq(4), delay = 0.25, loop = true)
  )
)
