/* Generated File */
package models.data.enemy

import models.animation.Animation
import models.template.enemy.EnemyTemplate

object GiantAcorn extends EnemyTemplate(
  key = "giantacorn",
  name = "GiantAcorn",
  width = 40,
  height = 40,
  hp = 4,
  damage = 25,
  isBoss = false,
  passiveSound = None,
  attackSounds = Seq("acorn_growl"),
  dieSound = Some("acorn_crush"),
  sounds = Seq("acorn_squeak"),
  animations = Seq(
    Animation(id = "dying.right", frames = IndexedSeq(0), delay = 0.25, loop = false),
    Animation(id = "dying.left", frames = IndexedSeq(1), delay = 0.25, loop = false),
    Animation(id = "default.right", frames = IndexedSeq(3, 4), delay = 0.25, loop = true),
    Animation(id = "default.left", frames = IndexedSeq(8, 9), delay = 0.25, loop = true),
    Animation(id = "hurt.right", frames = IndexedSeq(8, 9), delay = 0.25, loop = true),
    Animation(id = "hurt.left", frames = IndexedSeq(18, 19), delay = 0.25, loop = true),
    Animation(id = "attack.right", frames = IndexedSeq(8, 9), delay = 0.25, loop = true),
    Animation(id = "attack.left", frames = IndexedSeq(18, 19), delay = 0.25, loop = true),
    Animation(id = "rage.right", frames = IndexedSeq(8, 9), delay = 0.25, loop = true),
    Animation(id = "rage.left", frames = IndexedSeq(18, 19), delay = 0.25, loop = true),
    Animation(id = "dyingattack.right", frames = IndexedSeq(1), delay = 0.25, loop = false),
    Animation(id = "dyingattack.left", frames = IndexedSeq(3), delay = 0.25, loop = false)
  )
)
