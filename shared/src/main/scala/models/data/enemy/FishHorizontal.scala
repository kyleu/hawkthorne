/* Generated File */
package models.data.enemy

import models.animation.Animation
import models.template.enemy.EnemyTemplate

object FishHorizontal extends EnemyTemplate(
  key = "fish_horizontal",
  name = "FishHorizontal",
  width = 24,
  height = 24,
  hp = 4,
  damage = 10,
  isBoss = false,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = Some("acorn_squeak"),
  sounds = Seq.empty,
  animations = Seq(
    Animation(id = "dying.right", frames = IndexedSeq(5), delay = 1.0, loop = false),
    Animation(id = "dying.left", frames = IndexedSeq(2), delay = 1.0, loop = false),
    Animation(id = "default.right", frames = IndexedSeq(3, 4), delay = 0.3, loop = true),
    Animation(id = "default.left", frames = IndexedSeq(0, 1), delay = 0.3, loop = true),
    Animation(id = "hurt.right", frames = IndexedSeq(3, 4), delay = 0.3, loop = true),
    Animation(id = "hurt.left", frames = IndexedSeq(0, 1), delay = 0.3, loop = true)
  )
)
