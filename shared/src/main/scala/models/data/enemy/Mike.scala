/* Generated File */
package models.data.enemy

import models.template.enemy.EnemyTemplate

object Mike extends EnemyTemplate(
  key = "mike",
  name = "Mike",
  width = 48,
  height = 48,
  hp = 40,
  damage = 20,
  isBoss = false,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = None,
  sounds = Seq.empty,
  animations = Seq.empty
)
