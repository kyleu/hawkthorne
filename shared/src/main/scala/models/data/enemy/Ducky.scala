/* Generated File */
package models.data.enemy

import models.template.enemy.EnemyTemplate

object Ducky extends EnemyTemplate(
  key = "ducky",
  name = "Ducky",
  width = 30,
  height = 30,
  hp = 8,
  damage = 20,
  isBoss = false,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = Some("duckysqueak"),
  sounds = Seq.empty,
  animations = Seq.empty
)
