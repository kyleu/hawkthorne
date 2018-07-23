/* Generated File */
package models.data.enemy

import models.animation.Animation
import models.template.enemy.EnemyTemplate

object Alien extends EnemyTemplate(
  key = "alien",
  name = "Alien",
  width = 29,
  height = 48,
  hp = 8,
  damage = 8,
  isBoss = false,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = Some("alien_hurt"),
  sounds = Seq.empty,
  animations = Seq(
    Animation(id = "dying.right", frames = IndexedSeq(11), delay = 0.2, loop = true),
    Animation(id = "dying.left", frames = IndexedSeq(5), delay = 0.2, loop = true),
    Animation(id = "default.right", frames = IndexedSeq(5, 6, 7, 8, 9), delay = 0.2, loop = true),
    Animation(id = "default.left", frames = IndexedSeq(0, 1, 2, 3, 4), delay = 0.2, loop = true),
    Animation(id = "hurt.right", frames = IndexedSeq(11), delay = 0.2, loop = true),
    Animation(id = "hurt.left", frames = IndexedSeq(5), delay = 0.2, loop = true),
    Animation(id = "standing.right", frames = IndexedSeq(7), delay = 0.2, loop = true),
    Animation(id = "standing.left", frames = IndexedSeq(3), delay = 0.2, loop = true),
    Animation(id = "attack.right", frames = IndexedSeq(5, 6, 7, 8, 9), delay = 0.2, loop = true),
    Animation(id = "attack.left", frames = IndexedSeq(0, 1, 2, 3, 4), delay = 0.2, loop = true)
  )
)
