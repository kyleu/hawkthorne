/* Generated File */
package models.data.enemy

import models.animation.Animation
import models.template.enemy.EnemyTemplate

object Bat extends EnemyTemplate(
  key = "bat",
  name = "Bat",
  width = 30,
  height = 22,
  hp = 1,
  damage = 10,
  isBoss = false,
  passiveSound = None,
  attackSounds = Seq("bat_attack"),
  dieSound = Some("bat_die"),
  sounds = Seq.empty,
  animations = Seq(
    Animation(id = "dying.right", frames = IndexedSeq(1), delay = 1.0, loop = false),
    Animation(id = "dying.left", frames = IndexedSeq(1), delay = 1.0, loop = false),
    Animation(id = "default.right", frames = IndexedSeq(0), delay = 1.0, loop = false),
    Animation(id = "default.left", frames = IndexedSeq(0), delay = 1.0, loop = false),
    Animation(id = "hurt.right", frames = IndexedSeq(2, 3, 4), delay = 0.2, loop = true),
    Animation(id = "hurt.left", frames = IndexedSeq(2, 3, 4), delay = 0.2, loop = true),
    Animation(id = "dive.right", frames = IndexedSeq(1), delay = 1.0, loop = false),
    Animation(id = "dive.left", frames = IndexedSeq(1), delay = 1.0, loop = false),
    Animation(id = "flying.right", frames = IndexedSeq(2, 3, 4), delay = 0.2, loop = true),
    Animation(id = "flying.left", frames = IndexedSeq(2, 3, 4), delay = 0.2, loop = true)
  )
)
