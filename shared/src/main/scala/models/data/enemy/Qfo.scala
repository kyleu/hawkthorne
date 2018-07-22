/* Generated File */
package models.data.enemy

import models.template.enemy.EnemyTemplate

object Qfo extends EnemyTemplate(
  key = "qfo",
  name = "Qfo",
  width = 218,
  height = 60,
  hp = 60,
  damage = 30,
  isBoss = true,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = Some("explosion_quiet"),
  sounds = Seq("qfo_land"),
  animations = Seq.empty
)
