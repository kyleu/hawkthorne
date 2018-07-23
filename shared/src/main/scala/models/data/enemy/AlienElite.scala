/* Generated File */
package models.data.enemy

import models.animation.Animation
import models.template.enemy.EnemyTemplate

object AlienElite extends EnemyTemplate(
  key = "alien_elite",
  name = "AlienElite",
  width = 48,
  height = 48,
  hp = 20,
  damage = 35,
  isBoss = false,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = Some("alien_hurt"),
  sounds = Seq.empty,
  animations = Seq(
    Animation(id = "dying.right", frames = IndexedSeq(11), delay = 0.2, loop = true),
    Animation(id = "dying.left", frames = IndexedSeq(5), delay = 0.2, loop = true),
    Animation(id = "hurt.right", frames = IndexedSeq(11), delay = 0.2, loop = true),
    Animation(id = "hurt.left", frames = IndexedSeq(5), delay = 0.2, loop = true),
    Animation(id = "standing.right", frames = IndexedSeq(1), delay = 0.2, loop = true),
    Animation(id = "standing.left", frames = IndexedSeq(0), delay = 0.2, loop = true),
    Animation(id = "default.right", frames = IndexedSeq(7, 8, 9), delay = 0.2, loop = true),
    Animation(id = "default.left", frames = IndexedSeq(2, 3, 4), delay = 0.2, loop = true),
    Animation(id = "attack.right", frames = IndexedSeq(7, 8, 9), delay = 0.2, loop = true),
    Animation(id = "attack.left", frames = IndexedSeq(2, 3, 4), delay = 0.2, loop = true)
  )
)
