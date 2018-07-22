/* Generated File */
package models.data.enemy

import models.template.enemy.EnemyTemplate

object Goat extends EnemyTemplate(
  key = "goat",
  name = "Goat",
  width = 48,
  height = 48,
  hp = 1,
  damage = 0,
  isBoss = false,
  passiveSound = Some("goat"),
  attackSounds = Nil,
  dieSound = Some("goat"),
  sounds = Seq.empty,
  animations = Seq.empty
)
