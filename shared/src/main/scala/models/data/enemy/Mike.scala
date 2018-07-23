/* Generated File */
package models.data.enemy

import models.animation.Animation
import models.template.enemy.EnemyTemplate

object Mike extends EnemyTemplate(
  key = "mike",
  name = "Mike",
  width = 48,
  height = 48,
  hp = 40,
  damage = 20,
  isBoss = false,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = None,
  sounds = Seq.empty,
  animations = Seq(
    Animation(id = "attack.right", frames = IndexedSeq(5, 6, 7), delay = 0.25, loop = true),
    Animation(id = "attack.left", frames = IndexedSeq(1, 2, 3), delay = 0.25, loop = true),
    Animation(id = "default.right", frames = IndexedSeq(5, 6, 7), delay = 0.25, loop = true),
    Animation(id = "default.left", frames = IndexedSeq(1, 2, 3), delay = 0.25, loop = true),
    Animation(id = "hurt.right", frames = IndexedSeq(13), delay = 0.5, loop = false),
    Animation(id = "hurt.left", frames = IndexedSeq(6), delay = 0.5, loop = false),
    Animation(id = "dying.right", frames = IndexedSeq(13), delay = 0.5, loop = false),
    Animation(id = "dying.left", frames = IndexedSeq(6), delay = 0.5, loop = false),
    Animation(id = "standing.right", frames = IndexedSeq(1), delay = 0.2, loop = true),
    Animation(id = "standing.left", frames = IndexedSeq(0), delay = 0.2, loop = true),
    Animation(id = "pushattack.right", frames = IndexedSeq(10, 11), delay = 0.2, loop = true),
    Animation(id = "pushattack.left", frames = IndexedSeq(4, 5), delay = 0.2, loop = true)
  )
)
