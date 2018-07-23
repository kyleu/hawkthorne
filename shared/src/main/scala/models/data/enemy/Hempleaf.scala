/* Generated File */
package models.data.enemy

import models.animation.Animation
import models.template.enemy.EnemyTemplate

object Hempleaf extends EnemyTemplate(
  key = "hempleaf",
  name = "Hempleaf",
  width = 16,
  height = 7,
  hp = 2,
  damage = 18,
  isBoss = false,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = None,
  sounds = Seq.empty,
  animations = Seq(
    Animation(id = "dying.right", frames = IndexedSeq(1, 2), delay = 0.25, loop = false),
    Animation(id = "dying.left", frames = IndexedSeq(1, 2), delay = 0.25, loop = false),
    Animation(id = "default.right", frames = IndexedSeq(0), delay = 0.25, loop = true),
    Animation(id = "default.left", frames = IndexedSeq(0), delay = 0.25, loop = true),
    Animation(id = "hurt.right", frames = IndexedSeq(0), delay = 0.25, loop = true),
    Animation(id = "hurt.left", frames = IndexedSeq(0), delay = 0.25, loop = true),
    Animation(id = "attack.right", frames = IndexedSeq(0), delay = 0.25, loop = true),
    Animation(id = "attack.left", frames = IndexedSeq(0), delay = 0.25, loop = true)
  )
)
