/* Generated File */
package models.data.enemy

import models.animation.Animation
import models.template.enemy.EnemyTemplate

object Mannequin extends EnemyTemplate(
  key = "mannequin",
  name = "Mannequin",
  width = 48,
  height = 48,
  hp = 3,
  damage = 20,
  isBoss = false,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = Some("mannequin_death"),
  sounds = Seq.empty,
  animations = Seq(
    Animation(id = "default.right", frames = IndexedSeq(1), delay = 0.25, loop = true),
    Animation(id = "default.left", frames = IndexedSeq(0), delay = 0.25, loop = true),
    Animation(id = "hurt.right", frames = IndexedSeq(1), delay = 0.25, loop = true),
    Animation(id = "hurt.left", frames = IndexedSeq(0), delay = 0.25, loop = true),
    Animation(id = "move.right", frames = IndexedSeq(3, 4, 5), delay = 0.25, loop = true),
    Animation(id = "move.left", frames = IndexedSeq(0, 1, 2), delay = 0.25, loop = true),
    Animation(id = "attack.right", frames = IndexedSeq(8, 9), delay = 0.25, loop = true),
    Animation(id = "attack.left", frames = IndexedSeq(3, 4), delay = 0.25, loop = true),
    Animation(id = "dying.right", frames = IndexedSeq(5), delay = 1.0, loop = false),
    Animation(id = "dying.left", frames = IndexedSeq(5), delay = 1.0, loop = false)
  )
)
