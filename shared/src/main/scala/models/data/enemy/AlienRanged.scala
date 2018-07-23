/* Generated File */
package models.data.enemy

import models.animation.Animation
import models.template.enemy.EnemyTemplate

object AlienRanged extends EnemyTemplate(
  key = "alien_ranged",
  name = "AlienRanged",
  width = 48,
  height = 48,
  hp = 14,
  damage = 25,
  isBoss = false,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = Some("alien_hurt"),
  sounds = Seq("alien_laser"),
  animations = Seq(
    Animation(id = "dying.right", frames = IndexedSeq(11), delay = 0.2, loop = true),
    Animation(id = "dying.left", frames = IndexedSeq(5), delay = 0.2, loop = true),
    Animation(id = "default.right", frames = IndexedSeq(5, 9, 6), delay = 0.2, loop = true),
    Animation(id = "default.left", frames = IndexedSeq(0, 4, 1), delay = 0.2, loop = true),
    Animation(id = "hurt.right", frames = IndexedSeq(7), delay = 0.2, loop = true),
    Animation(id = "hurt.left", frames = IndexedSeq(3), delay = 0.2, loop = true),
    Animation(id = "standing.right", frames = IndexedSeq(5), delay = 0.2, loop = true),
    Animation(id = "standing.left", frames = IndexedSeq(2), delay = 0.2, loop = true),
    Animation(id = "attack.right", frames = IndexedSeq(5, 9, 6), delay = 0.2, loop = true),
    Animation(id = "attack.left", frames = IndexedSeq(0, 4, 1), delay = 0.2, loop = true)
  )
)
