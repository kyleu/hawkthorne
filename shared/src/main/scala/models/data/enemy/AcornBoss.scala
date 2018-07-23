/* Generated File */
package models.data.enemy

import models.animation.Animation
import models.template.enemy.EnemyTemplate

object AcornBoss extends EnemyTemplate(
  key = "acornBoss",
  name = "AcornBoss",
  width = 75,
  height = 75,
  hp = 100,
  damage = 10,
  isBoss = true,
  passiveSound = None,
  attackSounds = Seq("acorn_growl"),
  dieSound = None,
  sounds = Seq.empty,
  animations = Seq(
    Animation(id = "jump.right", frames = IndexedSeq(5), delay = 1.0, loop = true),
    Animation(id = "jump.left", frames = IndexedSeq(11), delay = 1.0, loop = true),
    Animation(id = "dying.right", frames = IndexedSeq(7), delay = 0.25, loop = false),
    Animation(id = "dying.left", frames = IndexedSeq(15), delay = 0.25, loop = false),
    Animation(id = "default.right", frames = IndexedSeq(1, 2, 3, 4), delay = 0.25, loop = true),
    Animation(id = "default.left", frames = IndexedSeq(6, 7, 8, 9), delay = 0.25, loop = true),
    Animation(id = "hurt.right", frames = IndexedSeq(6), delay = 0.25, loop = true),
    Animation(id = "hurt.left", frames = IndexedSeq(13), delay = 0.25, loop = true),
    Animation(id = "ragehurt.right", frames = IndexedSeq(5), delay = 1.0, loop = true),
    Animation(id = "ragehurt.left", frames = IndexedSeq(14), delay = 1.0, loop = true),
    Animation(id = "rageready1.right", frames = IndexedSeq(15, 16, 17), delay = 0.25, loop = true),
    Animation(id = "rageready1.left", frames = IndexedSeq(18, 19, 20), delay = 0.25, loop = true),
    Animation(id = "ragereadyjump1.right", frames = IndexedSeq(23), delay = 1.0, loop = true),
    Animation(id = "ragereadyjump1.left", frames = IndexedSeq(41), delay = 1.0, loop = true),
    Animation(id = "rageready2.right", frames = IndexedSeq(39, 40, 41), delay = 0.25, loop = true),
    Animation(id = "rageready2.left", frames = IndexedSeq(46, 47, 48), delay = 0.25, loop = true),
    Animation(id = "ragereadyjump2.right", frames = IndexedSeq(47), delay = 1.0, loop = true),
    Animation(id = "ragereadyjump2.left", frames = IndexedSeq(55), delay = 1.0, loop = true),
    Animation(id = "rage.right", frames = IndexedSeq(16, 17, 18, 19), delay = 0.15, loop = true),
    Animation(id = "rage.left", frames = IndexedSeq(21, 22, 23, 24), delay = 0.15, loop = true),
    Animation(id = "ragejump.right", frames = IndexedSeq(23), delay = 1.0, loop = true),
    Animation(id = "ragejump.left", frames = IndexedSeq(29), delay = 1.0, loop = true),
    Animation(id = "rageattack.right", frames = IndexedSeq(7), delay = 1.0, loop = true),
    Animation(id = "rageattack.left", frames = IndexedSeq(15), delay = 1.0, loop = true)
  )
)
