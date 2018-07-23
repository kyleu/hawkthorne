/* Generated File */
package models.data.enemy

import models.animation.Animation
import models.template.enemy.EnemyTemplate

object AlienHeavy extends EnemyTemplate(
  key = "alien_heavy",
  name = "AlienHeavy",
  width = 48,
  height = 48,
  hp = 12,
  damage = 8,
  isBoss = false,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = Some("alien_hurt"),
  sounds = Seq("alien_gatling"),
  animations = Seq(
    Animation(id = "hurt.right", frames = IndexedSeq(1), delay = 0.2, loop = true),
    Animation(id = "hurt.left", frames = IndexedSeq(3), delay = 0.2, loop = true),
    Animation(id = "default.right", frames = IndexedSeq(7, 5, 6), delay = 0.2, loop = true),
    Animation(id = "default.left", frames = IndexedSeq(1, 0, 2, 0), delay = 0.2, loop = true),
    Animation(id = "hurt.right", frames = IndexedSeq(1), delay = 0.2, loop = true),
    Animation(id = "hurt.left", frames = IndexedSeq(3), delay = 0.2, loop = true),
    Animation(id = "standing.right", frames = IndexedSeq(7), delay = 0.2, loop = true),
    Animation(id = "standing.left", frames = IndexedSeq(0), delay = 0.2, loop = true)
  )
)
