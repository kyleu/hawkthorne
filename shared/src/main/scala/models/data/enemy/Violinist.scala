/* Generated File */
package models.data.enemy

import models.template.enemy.EnemyTemplate

object Violinist extends EnemyTemplate(
  key = "violinist",
  name = "Violinist",
  width = 48,
  height = 48,
  hp = 12,
  damage = 20,
  isBoss = false,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = Some("trombone_temp"),
  sounds = Seq.empty,
  animations = Seq.empty
)
