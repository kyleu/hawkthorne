/* Generated File */
package models.data.enemy

import models.animation.Animation
import models.template.enemy.EnemyTemplate

object Pinata extends EnemyTemplate(
  key = "pinata",
  name = "Pinata",
  width = 19,
  height = 39,
  hp = 1,
  damage = 0,
  isBoss = false,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = Some("acorn_crush"),
  sounds = Seq.empty,
  animations = Seq(
    Animation(id = "default.left", frames = IndexedSeq(0), delay = 1.0, loop = true),
    Animation(id = "default.right", frames = IndexedSeq(0), delay = 1.0, loop = true),
    Animation(id = "hurt.left", frames = IndexedSeq(0), delay = 1.0, loop = true),
    Animation(id = "hurt.right", frames = IndexedSeq(0), delay = 1.0, loop = true),
    Animation(id = "dying.left", frames = IndexedSeq(0), delay = 1.0, loop = true),
    Animation(id = "dying.right", frames = IndexedSeq(0), delay = 1.0, loop = true)
  )
)
