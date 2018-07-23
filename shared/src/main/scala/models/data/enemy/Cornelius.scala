/* Generated File */
package models.data.enemy

import models.animation.Animation
import models.template.enemy.EnemyTemplate

object Cornelius extends EnemyTemplate(
  key = "cornelius",
  name = "Cornelius",
  width = 200,
  height = 220,
  hp = 200,
  damage = 30,
  isBoss = true,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = None,
  sounds = Seq("teleport", "cornelius-ending"),
  animations = Seq(
    Animation(id = "default.right", frames = IndexedSeq(3, 4, 5, 4), delay = 0.1, loop = true),
    Animation(id = "default.left", frames = IndexedSeq(3, 4, 5, 4), delay = 0.1, loop = true),
    Animation(id = "talking.right", frames = IndexedSeq(0, 1, 2, 1), delay = 0.15, loop = true),
    Animation(id = "talking.left", frames = IndexedSeq(0, 1, 2, 1), delay = 0.15, loop = true),
    Animation(id = "attack.right", frames = IndexedSeq(3, 4, 5, 4), delay = 0.1, loop = true),
    Animation(id = "attack.left", frames = IndexedSeq(3, 4, 5, 4), delay = 0.1, loop = true),
    Animation(id = "hurt.right", frames = IndexedSeq(9, 10, 11, 4), delay = 0.1, loop = true),
    Animation(id = "hurt.left", frames = IndexedSeq(9, 10, 11, 4), delay = 0.1, loop = true),
    Animation(id = "dying.right", frames = IndexedSeq(12, 13, 14, 13), delay = 0.15, loop = true),
    Animation(id = "dying.left", frames = IndexedSeq(12, 13, 14, 13), delay = 0.15, loop = true),
    Animation(id = "before_death.right", frames = IndexedSeq(12, 13, 14, 13), delay = 0.15, loop = true),
    Animation(id = "before_death.left", frames = IndexedSeq(12, 13, 14, 13), delay = 0.15, loop = true),
    Animation(id = "enter.right", frames = IndexedSeq(0), delay = 0.2, loop = false),
    Animation(id = "enter.left", frames = IndexedSeq(0), delay = 0.2, loop = false),
    Animation(id = "teleport.right", frames = IndexedSeq(6, 7, 8, 7), delay = 0.1, loop = true),
    Animation(id = "teleport.left", frames = IndexedSeq(6, 7, 8, 7), delay = 0.1, loop = true)
  )
)
