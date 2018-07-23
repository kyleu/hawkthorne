/* Generated File */
package models.data.enemy

import models.animation.Animation
import models.template.enemy.EnemyTemplate

object TSnake extends EnemyTemplate(
  key = "tSnake",
  name = "TSnake",
  width = 48,
  height = 144,
  hp = 70,
  damage = 40,
  isBoss = true,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = Some("snake_hurt"),
  sounds = Seq.empty,
  animations = Seq(
    Animation(id = "default.right", frames = IndexedSeq(4, 5, 6, 7), delay = 0.15, loop = true),
    Animation(id = "default.left", frames = IndexedSeq(0, 1, 2, 3), delay = 0.15, loop = true),
    Animation(id = "attack.right", frames = IndexedSeq(11, 12, 13), delay = 0.15, loop = false),
    Animation(id = "attack.left", frames = IndexedSeq(4, 5, 6), delay = 0.15, loop = false),
    Animation(id = "dying.right", frames = IndexedSeq(22, 23, 24, 25, 26, 27), delay = 0.1, loop = false),
    Animation(id = "dying.left", frames = IndexedSeq(8, 9, 10, 11, 12, 13), delay = 0.1, loop = false),
    Animation(id = "enter.right", frames = IndexedSeq(1), delay = 0.25, loop = false),
    Animation(id = "enter.left", frames = IndexedSeq(0), delay = 0.25, loop = false),
    Animation(id = "hurt.right", frames = IndexedSeq(15), delay = 0.25, loop = false),
    Animation(id = "hurt.left", frames = IndexedSeq(7), delay = 0.25, loop = false)
  )
)
