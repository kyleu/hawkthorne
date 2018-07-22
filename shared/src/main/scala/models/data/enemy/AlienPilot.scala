/* Generated File */
package models.data.enemy

import models.template.enemy.EnemyTemplate

object AlienPilot extends EnemyTemplate(
  key = "alien_pilot",
  name = "AlienPilot",
  width = 51,
  height = 51,
  hp = 8,
  damage = 30,
  isBoss = false,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = None,
  sounds = Seq.empty,
  animations = Seq.empty
)
