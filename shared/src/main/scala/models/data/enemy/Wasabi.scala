/* Generated File */
package models.data.enemy

import models.animation.Animation
import models.template.enemy.EnemyTemplate

object Wasabi extends EnemyTemplate(
  key = "wasabi",
  name = "Wasabi",
  width = 36,
  height = 36,
  hp = 8,
  damage = 30,
  isBoss = false,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = Some("acorn_crush"),
  sounds = Seq.empty,
  animations = Seq(
    Animation(id = "default.left", frames = IndexedSeq(8, 9, 10, 11), delay = 0.25, loop = true),
    Animation(id = "default.right", frames = IndexedSeq(0, 1, 2, 3), delay = 0.25, loop = true),
    Animation(id = "jump.left", frames = IndexedSeq(19), delay = 1.0, loop = false),
    Animation(id = "jump.right", frames = IndexedSeq(9), delay = 1.0, loop = false),
    Animation(id = "attack.left", frames = IndexedSeq(6, 7), delay = 0.1, loop = true),
    Animation(id = "attack.right", frames = IndexedSeq(2, 3), delay = 0.1, loop = true),
    Animation(id = "hurt.left", frames = IndexedSeq(11), delay = 0.4, loop = true),
    Animation(id = "hurt.right", frames = IndexedSeq(5), delay = 0.4, loop = true),
    Animation(id = "dying.left", frames = IndexedSeq(7), delay = 0.4, loop = false),
    Animation(id = "dying.right", frames = IndexedSeq(15), delay = 0.4, loop = false)
  )
)
