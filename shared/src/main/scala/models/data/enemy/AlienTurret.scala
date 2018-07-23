/* Generated File */
package models.data.enemy

import models.animation.Animation
import models.template.enemy.EnemyTemplate

object AlienTurret extends EnemyTemplate(
  key = "alien_turret",
  name = "AlienTurret",
  width = 48,
  height = 48,
  hp = 5,
  damage = 25,
  isBoss = false,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = Some("boulder-crumble"),
  sounds = Seq("alien_gatling"),
  animations = Seq(
    Animation(id = "dying.right", frames = IndexedSeq(1, 2, 3), delay = 0.2, loop = true),
    Animation(id = "dying.left", frames = IndexedSeq(5, 6, 7), delay = 0.2, loop = true),
    Animation(id = "default.right", frames = IndexedSeq(0), delay = 0.2, loop = true),
    Animation(id = "default.left", frames = IndexedSeq(7), delay = 0.2, loop = true),
    Animation(id = "shooting.right", frames = IndexedSeq(0), delay = 0.2, loop = true),
    Animation(id = "shooting.left", frames = IndexedSeq(7), delay = 0.2, loop = true)
  )
)
