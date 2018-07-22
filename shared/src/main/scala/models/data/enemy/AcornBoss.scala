/* Generated File */
package models.data.enemy

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
  animations = Seq.empty
)
