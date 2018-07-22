/* Generated File */
package models.data.enemy

import models.template.enemy.EnemyTemplate

object BenzalkBoss extends EnemyTemplate(
  key = "benzalkBoss",
  name = "BenzalkBoss",
  width = 90,
  height = 90,
  hp = 100,
  damage = 40,
  isBoss = true,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = None,
  sounds = Seq("benzalk_growl", "jump_boom"),
  animations = Seq.empty
)
