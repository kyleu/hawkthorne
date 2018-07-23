/* Generated File */
package models.data.enemy

import models.animation.Animation
import models.template.enemy.EnemyTemplate

object Humbug extends EnemyTemplate(
  key = "humbug",
  name = "Humbug",
  width = 58,
  height = 40,
  hp = 1,
  damage = 10,
  isBoss = false,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = Some("acorn_crush"),
  sounds = Seq.empty,
  animations = Seq(
    Animation(id = "dying.right", frames = IndexedSeq(13), delay = 0.4, loop = false),
    Animation(id = "dying.left", frames = IndexedSeq(6), delay = 0.4, loop = false),
    Animation(id = "default.right", frames = IndexedSeq(6, 7, 8, 9, 10, 11), delay = 0.1, loop = true),
    Animation(id = "default.left", frames = IndexedSeq(0, 1, 2, 3, 4, 5), delay = 0.1, loop = true),
    Animation(id = "hurt.right", frames = IndexedSeq(6, 7, 8, 9, 10, 11), delay = 0.1, loop = true),
    Animation(id = "hurt.left", frames = IndexedSeq(0, 1, 2, 3, 4, 5), delay = 0.1, loop = true),
    Animation(id = "attack.right", frames = IndexedSeq(18, 19, 20, 21, 22, 23), delay = 0.05, loop = true),
    Animation(id = "attack.left", frames = IndexedSeq(12, 13, 14, 15, 16, 17), delay = 0.05, loop = true)
  )
)
