/* Generated File */
package models.data.enemy

import models.animation.Animation
import models.template.enemy.EnemyTemplate

object Wipe extends EnemyTemplate(
  key = "wipe",
  name = "Wipe",
  width = 24,
  height = 24,
  hp = 3,
  damage = 20,
  isBoss = false,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = None,
  sounds = Seq.empty,
  animations = Seq(
    Animation(id = "dying.right", frames = IndexedSeq(19), delay = 0.25, loop = false),
    Animation(id = "dying.left", frames = IndexedSeq(14), delay = 0.25, loop = false),
    Animation(id = "default.right", frames = IndexedSeq(13, 14, 15), delay = 0.25, loop = true),
    Animation(id = "default.left", frames = IndexedSeq(9, 10, 11), delay = 0.25, loop = true),
    Animation(id = "hurt.right", frames = IndexedSeq(13, 14, 15), delay = 0.25, loop = true),
    Animation(id = "hurt.left", frames = IndexedSeq(9, 10, 11), delay = 0.25, loop = true),
    Animation(id = "enter.right", frames = IndexedSeq(7), delay = 0.25, loop = false),
    Animation(id = "enter.left", frames = IndexedSeq(3), delay = 0.25, loop = false),
    Animation(id = "flying.right", frames = IndexedSeq(5), delay = 0.25, loop = false),
    Animation(id = "flying.left", frames = IndexedSeq(2), delay = 0.25, loop = false),
    Animation(id = "attack.right", frames = IndexedSeq(11), delay = 0.25, loop = true),
    Animation(id = "attack.left", frames = IndexedSeq(8), delay = 0.25, loop = true)
  )
)
