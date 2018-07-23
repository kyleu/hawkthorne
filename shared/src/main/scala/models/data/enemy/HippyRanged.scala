/* Generated File */
package models.data.enemy

import models.animation.Animation
import models.template.enemy.EnemyTemplate

object HippyRanged extends EnemyTemplate(
  key = "hippy-ranged",
  name = "HippyRanged",
  width = 48,
  height = 48,
  hp = 6,
  damage = 10,
  isBoss = false,
  passiveSound = None,
  attackSounds = Seq("peace", "sex", "drugs"),
  dieSound = Some("hippy_kill"),
  sounds = Seq("peace", "drugs", "sex", "throw"),
  animations = Seq(
    Animation(id = "dying.right", frames = IndexedSeq(17), delay = 0.25, loop = false),
    Animation(id = "dying.left", frames = IndexedSeq(8), delay = 0.25, loop = false),
    Animation(id = "default.left", frames = IndexedSeq(4, 5, 6, 7), delay = 0.2, loop = true),
    Animation(id = "default.right", frames = IndexedSeq(12, 13, 14, 15), delay = 0.2, loop = true),
    Animation(id = "hurt.left", frames = IndexedSeq(0), delay = 0.25, loop = false),
    Animation(id = "hurt.right", frames = IndexedSeq(1), delay = 0.25, loop = false),
    Animation(id = "attack.left", frames = IndexedSeq(4, 5, 6, 7), delay = 0.2, loop = true),
    Animation(id = "attack.right", frames = IndexedSeq(12, 13, 14, 15), delay = 0.2, loop = true),
    Animation(id = "attackranged.left", frames = IndexedSeq(1, 2, 3), delay = 0.25, loop = true),
    Animation(id = "attackranged.right", frames = IndexedSeq(5, 6, 7), delay = 0.25, loop = true)
  )
)
