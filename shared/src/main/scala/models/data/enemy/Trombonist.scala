/* Generated File */
package models.data.enemy

import models.animation.Animation
import models.template.enemy.EnemyTemplate

object Trombonist extends EnemyTemplate(
  key = "trombonist",
  name = "Trombonist",
  width = 58,
  height = 39,
  hp = 8,
  damage = 20,
  isBoss = false,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = Some("trombone_temp"),
  sounds = Seq.empty,
  animations = Seq(
    Animation(id = "dying.right", frames = IndexedSeq(0, 1, 2, 3), delay = 0.25, loop = true),
    Animation(id = "dying.left", frames = IndexedSeq(4, 5, 6, 7), delay = 0.25, loop = true),
    Animation(id = "default.right", frames = IndexedSeq(3, 0, 1), delay = 0.25, loop = true),
    Animation(id = "default.left", frames = IndexedSeq(4, 6, 7), delay = 0.25, loop = true),
    Animation(id = "hurt.right", frames = IndexedSeq(3, 0, 1), delay = 0.25, loop = true),
    Animation(id = "hurt.left", frames = IndexedSeq(4, 6, 7), delay = 0.25, loop = true),
    Animation(id = "dying.right", frames = IndexedSeq(3, 0, 1), delay = 0.25, loop = true),
    Animation(id = "dying.left", frames = IndexedSeq(4, 6, 7), delay = 0.25, loop = true)
  )
)
