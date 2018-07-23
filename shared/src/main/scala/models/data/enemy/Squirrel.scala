/* Generated File */
package models.data.enemy

import models.animation.Animation
import models.template.enemy.EnemyTemplate

object Squirrel extends EnemyTemplate(
  key = "squirrel",
  name = "Squirrel",
  width = 44,
  height = 30,
  hp = 1,
  damage = 0,
  isBoss = false,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = Some("squirrel_death"),
  sounds = Seq.empty,
  animations = Seq(
    Animation(id = "dying.right", frames = IndexedSeq(13), delay = 0.25, loop = false),
    Animation(id = "dying.left", frames = IndexedSeq(6), delay = 0.25, loop = false),
    Animation(id = "default.right", frames = IndexedSeq(5, 6, 7), delay = 0.3, loop = true),
    Animation(id = "default.left", frames = IndexedSeq(1, 2, 3), delay = 0.3, loop = true),
    Animation(id = "hurt.left", frames = IndexedSeq(0), delay = 0.25, loop = true),
    Animation(id = "hurt.right", frames = IndexedSeq(1), delay = 0.25, loop = true),
    Animation(id = "attack.left", frames = IndexedSeq(0, 4, 5), delay = 0.25, loop = true),
    Animation(id = "attack.right", frames = IndexedSeq(6, 10, 11), delay = 0.25, loop = true),
    Animation(id = "attackranged.left", frames = IndexedSeq(0), delay = 0.25, loop = false),
    Animation(id = "attackranged.right", frames = IndexedSeq(1), delay = 0.25, loop = false),
    Animation(id = "attackthrow.left", frames = IndexedSeq(4, 5), delay = 0.25, loop = false),
    Animation(id = "attackthrow.right", frames = IndexedSeq(10, 11), delay = 0.25, loop = false)
  )
)
