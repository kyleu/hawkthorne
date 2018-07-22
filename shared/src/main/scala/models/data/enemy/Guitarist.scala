/* Generated File */
package models.data.enemy

import models.template.enemy.EnemyTemplate

object Guitarist extends EnemyTemplate(
  key = "guitarist",
  name = "Guitarist",
  width = 48,
  height = 48,
  hp = 16,
  damage = 30,
  isBoss = false,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = Some("trombone_temp"),
  sounds = Seq.empty,
  animations = Seq.empty
)
