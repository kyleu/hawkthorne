/* Generated File */
package models.data.enemy

import models.template.enemy.EnemyTemplate

object Cannon extends EnemyTemplate(
  key = "cannon",
  name = "Cannon",
  width = 24,
  height = 13,
  hp = 5,
  damage = 0,
  isBoss = false,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = None,
  sounds = Seq.empty,
  animations = Seq.empty
)
