/* Generated File */
package models.data.enemy

import models.enemy.EnemyTemplate

object Bird extends EnemyTemplate(
  key = "bird",
  name = "Bird",
  width = 32,
  height = 32,
  hp = 6,
  damage = 10,
  isBoss = false,
  animations = Seq.empty
)
