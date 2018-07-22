/* Generated File */
package models.data.enemy

import models.template.enemy.EnemyTemplate

object TSnake extends EnemyTemplate(
  key = "tSnake",
  name = "TSnake",
  width = 48,
  height = 144,
  hp = 70,
  damage = 40,
  isBoss = true,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = Some("snake_hurt"),
  sounds = Seq.empty,
  animations = Seq.empty
)
