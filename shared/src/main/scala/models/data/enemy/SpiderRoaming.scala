/* Generated File */
package models.data.enemy

import models.animation.Animation
import models.template.enemy.EnemyTemplate

object SpiderRoaming extends EnemyTemplate(
  key = "spider-roaming",
  name = "SpiderRoaming",
  width = 48,
  height = 48,
  hp = 12,
  damage = 20,
  isBoss = false,
  passiveSound = Some("spider-growl"),
  attackSounds = Nil,
  dieSound = Some("acorn_crush"),
  sounds = Seq.empty,
  animations = Seq(
    Animation(id = "dropping.right", frames = IndexedSeq(0), delay = 1.0, loop = false),
    Animation(id = "dropping.left", frames = IndexedSeq(0), delay = 1.0, loop = false),
    Animation(id = "dying.right", frames = IndexedSeq(11), delay = 1.0, loop = false),
    Animation(id = "dying.left", frames = IndexedSeq(7), delay = 1.0, loop = false),
    Animation(id = "hurt.right", frames = IndexedSeq(8), delay = 1.0, loop = false),
    Animation(id = "hurt.left", frames = IndexedSeq(5), delay = 1.0, loop = false),
    Animation(id = "default.right", frames = IndexedSeq(7, 8), delay = 0.2, loop = true),
    Animation(id = "default.left", frames = IndexedSeq(4, 5), delay = 0.2, loop = true),
    Animation(id = "attack.right", frames = IndexedSeq(2), delay = 1.0, loop = false),
    Animation(id = "attack.left", frames = IndexedSeq(1), delay = 1.0, loop = false)
  )
)
