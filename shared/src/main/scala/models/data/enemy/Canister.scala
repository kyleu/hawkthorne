/* Generated File */
package models.data.enemy

import models.animation.Animation
import models.template.enemy.EnemyTemplate

object Canister extends EnemyTemplate(
  key = "canister",
  name = "Canister",
  width = 24,
  height = 24,
  hp = 12,
  damage = 0,
  isBoss = false,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = None,
  sounds = Seq.empty,
  animations = Seq(
    Animation(id = "dying.right", frames = IndexedSeq(1), delay = 0.25, loop = false),
    Animation(id = "dying.left", frames = IndexedSeq(1), delay = 0.25, loop = false),
    Animation(id = "default.right", frames = IndexedSeq(1), delay = 0.25, loop = true),
    Animation(id = "default.left", frames = IndexedSeq(3), delay = 0.25, loop = true),
    Animation(id = "hurt.right", frames = IndexedSeq(1), delay = 0.25, loop = true),
    Animation(id = "hurt.left", frames = IndexedSeq(3), delay = 0.25, loop = true)
  )
)
