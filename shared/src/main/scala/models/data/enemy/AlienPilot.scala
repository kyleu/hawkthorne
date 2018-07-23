/* Generated File */
package models.data.enemy

import models.animation.Animation
import models.template.enemy.EnemyTemplate

object AlienPilot extends EnemyTemplate(
  key = "alien_pilot",
  name = "AlienPilot",
  width = 51,
  height = 51,
  hp = 8,
  damage = 30,
  isBoss = false,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = None,
  sounds = Seq.empty,
  animations = Seq(
    Animation(id = "default.right", frames = IndexedSeq(0, 1, 2, 3), delay = 0.2, loop = true),
    Animation(id = "default.left", frames = IndexedSeq(0, 1, 2, 3), delay = 0.2, loop = true),
    Animation(id = "hurt.right", frames = IndexedSeq(0, 1, 2, 3), delay = 0.2, loop = true),
    Animation(id = "hurt.left", frames = IndexedSeq(0, 1, 2, 3), delay = 0.2, loop = true)
  )
)
