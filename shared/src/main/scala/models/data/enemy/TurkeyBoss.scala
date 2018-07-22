/* Generated File */
package models.data.enemy

import models.template.enemy.EnemyTemplate

object TurkeyBoss extends EnemyTemplate(
  key = "turkeyBoss",
  name = "TurkeyBoss",
  width = 215,
  height = 115,
  hp = 100,
  damage = 40,
  isBoss = true,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = None,
  sounds = Seq.empty,
  animations = Seq.empty
)
