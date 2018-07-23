/* Generated File */
package models.data.enemy

import models.animation.Animation
import models.template.enemy.EnemyTemplate

object Manicorn extends EnemyTemplate(
  key = "manicorn",
  name = "Manicorn",
  width = 48,
  height = 48,
  hp = 13,
  damage = 40,
  isBoss = false,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = Some("manicorn_neigh"),
  sounds = Seq.empty,
  animations = Seq(
    Animation(id = "dying.right", frames = IndexedSeq(2, 5), delay = 0.25, loop = false),
    Animation(id = "dying.left", frames = IndexedSeq(34, 38), delay = 0.25, loop = false),
    Animation(id = "default.left", frames = IndexedSeq(6, 7, 8, 9), delay = 0.25, loop = true),
    Animation(id = "default.right", frames = IndexedSeq(12, 13), delay = 0.25, loop = true),
    Animation(id = "hurt.left", frames = IndexedSeq(1), delay = 0.25, loop = true),
    Animation(id = "hurt.right", frames = IndexedSeq(34), delay = 0.25, loop = true),
    Animation(id = "attack.left", frames = IndexedSeq(1, 2, 3, 4), delay = 0.25, loop = true),
    Animation(id = "attack.right", frames = IndexedSeq(20, 21, 22, 23), delay = 0.25, loop = true),
    Animation(id = "attackrainbow_start.left", frames = IndexedSeq(5), delay = 1.0, loop = false),
    Animation(id = "attackrainbow_start.right", frames = IndexedSeq(31), delay = 1.0, loop = false),
    Animation(id = "attackrainbow_charging.left", frames = IndexedSeq(5), delay = 1.0, loop = false),
    Animation(id = "attackrainbow_charging.right", frames = IndexedSeq(31), delay = 1.0, loop = false)
  )
)
