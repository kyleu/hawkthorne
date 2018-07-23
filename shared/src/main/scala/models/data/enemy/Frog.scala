/* Generated File */
package models.data.enemy

import models.animation.Animation
import models.template.enemy.EnemyTemplate

object Frog extends EnemyTemplate(
  key = "frog",
  name = "Frog",
  width = 48,
  height = 48,
  hp = 1,
  damage = 20,
  isBoss = false,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = Some("karramba_pop"),
  sounds = Seq.empty,
  animations = Seq(
    Animation(id = "dying.right", frames = IndexedSeq(12, 13, 14, 15), delay = 0.2, loop = false),
    Animation(id = "dying.left", frames = IndexedSeq(4, 5, 6, 7), delay = 0.2, loop = false),
    Animation(id = "default.right", frames = IndexedSeq(1), delay = 1.0, loop = true),
    Animation(id = "default.left", frames = IndexedSeq(0), delay = 1.0, loop = true),
    Animation(id = "hurt.right", frames = IndexedSeq(1), delay = 1.0, loop = true),
    Animation(id = "hurt.left", frames = IndexedSeq(0), delay = 1.0, loop = true),
    Animation(id = "emerge.right", frames = IndexedSeq(3), delay = 1.0, loop = true),
    Animation(id = "emerge.left", frames = IndexedSeq(1), delay = 1.0, loop = true),
    Animation(id = "dive.right", frames = IndexedSeq(3), delay = 1.0, loop = true),
    Animation(id = "dive.left", frames = IndexedSeq(1), delay = 1.0, loop = true),
    Animation(id = "fall.right", frames = IndexedSeq(7), delay = 1.0, loop = true),
    Animation(id = "fall.left", frames = IndexedSeq(3), delay = 1.0, loop = true),
    Animation(id = "leap.right", frames = IndexedSeq(5), delay = 1.0, loop = true),
    Animation(id = "leap.left", frames = IndexedSeq(2), delay = 1.0, loop = true)
  )
)
