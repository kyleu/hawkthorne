/* Generated File */
package models.data.enemy

import models.animation.Animation
import models.template.enemy.EnemyTemplate

object Qfo extends EnemyTemplate(
  key = "qfo",
  name = "Qfo",
  width = 218,
  height = 60,
  hp = 60,
  damage = 30,
  isBoss = true,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = Some("explosion_quiet"),
  sounds = Seq("qfo_land"),
  animations = Seq(
    Animation(id = "default.right", frames = IndexedSeq(0, 1, 2, 3, 4, 5, 6), delay = 0.1, loop = true),
    Animation(id = "default.left", frames = IndexedSeq(0, 1, 2, 3, 4, 5, 6), delay = 0.1, loop = true),
    Animation(id = "dying.right", frames = IndexedSeq(7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26), delay = 0.1, loop = false),
    Animation(id = "dying.left", frames = IndexedSeq(7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26), delay = 0.1, loop = false),
    Animation(id = "enter.right", frames = IndexedSeq(0), delay = 0.25, loop = false),
    Animation(id = "enter.left", frames = IndexedSeq(0), delay = 0.25, loop = false),
    Animation(id = "hurt.right", frames = IndexedSeq(0), delay = 0.1, loop = true),
    Animation(id = "hurt.left", frames = IndexedSeq(0), delay = 0.1, loop = true)
  )
)
