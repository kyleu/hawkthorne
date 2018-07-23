/* Generated File */
package models.data.enemy

import models.animation.Animation
import models.template.enemy.EnemyTemplate

object JumpingAcorn extends EnemyTemplate(
  key = "jumpingacorn",
  name = "JumpingAcorn",
  width = 20,
  height = 20,
  hp = 1,
  damage = 15,
  isBoss = false,
  passiveSound = None,
  attackSounds = Seq("acorn_growl"),
  dieSound = Some("acorn_crush"),
  sounds = Seq.empty,
  animations = Seq(
    Animation(id = "dying.right", frames = IndexedSeq(0), delay = 0.25, loop = false),
    Animation(id = "dying.left", frames = IndexedSeq(1), delay = 0.25, loop = false),
    Animation(id = "default.right", frames = IndexedSeq(6, 7, 8), delay = 0.25, loop = true),
    Animation(id = "default.left", frames = IndexedSeq(15, 16, 17), delay = 0.25, loop = true),
    Animation(id = "jumping.right", frames = IndexedSeq(9, 10), delay = 0.25, loop = true),
    Animation(id = "jumping.left", frames = IndexedSeq(20, 21), delay = 0.25, loop = true),
    Animation(id = "dyingattack.right", frames = IndexedSeq(1), delay = 0.25, loop = false),
    Animation(id = "dyingattack.left", frames = IndexedSeq(3), delay = 0.25, loop = false)
  )
)
