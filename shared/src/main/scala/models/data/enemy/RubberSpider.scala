/* Generated File */
package models.data.enemy

import models.animation.Animation
import models.template.enemy.EnemyTemplate

object RubberSpider extends EnemyTemplate(
  key = "rubberspider",
  name = "RubberSpider",
  width = 24,
  height = 24,
  hp = 100000,
  damage = 0,
  isBoss = false,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = Some("boing"),
  sounds = Seq.empty,
  animations = Seq(
    Animation(id = "default.left", frames = IndexedSeq(0), delay = 1.0, loop = true),
    Animation(id = "default.right", frames = IndexedSeq(0), delay = 1.0, loop = true),
    Animation(id = "hurt.right", frames = IndexedSeq(1, 2, 3, 4), delay = 1.0, loop = false),
    Animation(id = "hurt.left", frames = IndexedSeq(6, 7, 8, 9), delay = 1.0, loop = false),
    Animation(id = "dying.right", frames = IndexedSeq(1, 2, 3, 4), delay = 1.0, loop = false),
    Animation(id = "dying.left", frames = IndexedSeq(6, 7, 8, 9), delay = 1.0, loop = false)
  )
)
