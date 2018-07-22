/* Generated File */
package models.data.enemy

import models.template.enemy.EnemyTemplate

object Monkey extends EnemyTemplate(
  key = "monkey",
  name = "Monkey",
  width = 23,
  height = 29,
  hp = 1,
  damage = 0,
  isBoss = false,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = None,
  sounds = Seq.empty,
  animations = Seq.empty
)
