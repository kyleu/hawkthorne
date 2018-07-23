/* Generated File */
package models.data.enemy

import models.animation.Animation
import models.template.enemy.EnemyTemplate

object AcornPod extends EnemyTemplate(
  key = "acornpod",
  name = "AcornPod",
  width = 24,
  height = 24,
  hp = 1000,
  damage = 5,
  isBoss = false,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = None,
  sounds = Seq.empty,
  animations = Seq(
    Animation(id = "attack.right", frames = IndexedSeq(0, 1), delay = 0.2, loop = true),
    Animation(id = "attack.left", frames = IndexedSeq(0, 1), delay = 0.2, loop = true),
    Animation(id = "default.right", frames = IndexedSeq(0), delay = 0.25, loop = true),
    Animation(id = "default.left", frames = IndexedSeq(0), delay = 0.25, loop = true),
    Animation(id = "hurt.right", frames = IndexedSeq(0, 1), delay = 0.2, loop = true),
    Animation(id = "hurt.left", frames = IndexedSeq(0, 1), delay = 0.2, loop = true),
    Animation(id = "dying.right", frames = IndexedSeq(0, 1), delay = 0.25, loop = false),
    Animation(id = "dying.left", frames = IndexedSeq(0, 1), delay = 0.25, loop = false)
  )
)
