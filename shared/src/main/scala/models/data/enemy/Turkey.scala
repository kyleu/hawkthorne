/* Generated File */
package models.data.enemy

import models.animation.Animation
import models.template.enemy.EnemyTemplate

object Turkey extends EnemyTemplate(
  key = "turkey",
  name = "Turkey",
  width = 72,
  height = 72,
  hp = 8,
  damage = 30,
  isBoss = false,
  passiveSound = Some("turkey_attack"),
  attackSounds = Seq("turkey_attack"),
  dieSound = None,
  sounds = Seq.empty,
  animations = Seq(
    Animation(id = "jump.right", frames = IndexedSeq(6, 7), delay = 0.25, loop = true),
    Animation(id = "jump.left", frames = IndexedSeq(2, 3), delay = 0.25, loop = true),
    Animation(id = "default.right", frames = IndexedSeq(2, 3), delay = 0.25, loop = true),
    Animation(id = "default.left", frames = IndexedSeq(0, 1), delay = 0.25, loop = true),
    Animation(id = "hurt.right", frames = IndexedSeq(2, 3), delay = 0.25, loop = true),
    Animation(id = "hurt.left", frames = IndexedSeq(0, 1), delay = 0.25, loop = true),
    Animation(id = "dying.right", frames = IndexedSeq(8, 9, 10, 11), delay = 0.25, loop = false),
    Animation(id = "dying.left", frames = IndexedSeq(8, 9, 10, 11), delay = 0.25, loop = false)
  )
)
