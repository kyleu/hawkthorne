/* Generated File */
package models.data.enemy

import models.template.enemy.EnemyTemplate

object Bat extends EnemyTemplate(
  key = "bat",
  name = "Bat",
  width = 30,
  height = 22,
  hp = 1,
  damage = 10,
  isBoss = false,
  animations = Seq.empty
)
