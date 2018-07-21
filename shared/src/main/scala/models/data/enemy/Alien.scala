/* Generated File */
package models.data.enemy

import models.enemy.EnemyTemplate

object Alien extends EnemyTemplate(
  key = "alien",
  name = "Alien",
  width = 29,
  height = 48,
  hp = 8,
  damage = 8,
  isBoss = false,
  animations = Seq.empty
)
