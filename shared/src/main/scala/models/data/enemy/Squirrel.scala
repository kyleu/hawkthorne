/* Generated File */
package models.data.enemy

import models.template.enemy.EnemyTemplate

object Squirrel extends EnemyTemplate(
  key = "squirrel",
  name = "Squirrel",
  width = 44,
  height = 30,
  hp = 1,
  damage = 0,
  isBoss = false,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = Some("squirrel_death"),
  sounds = Seq.empty,
  animations = Seq.empty
)
