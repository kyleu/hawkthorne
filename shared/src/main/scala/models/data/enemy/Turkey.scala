/* Generated File */
package models.data.enemy

import models.template.enemy.EnemyTemplate

object Turkey extends EnemyTemplate(
  key = "turkey",
  name = "Turkey",
  width = 72,
  height = 72,
  hp = 8,
  damage = 30,
  isBoss = false,
  passiveSound = Some("turkey_attack"),
  attackSounds = Seq("turkey_attack"),
  dieSound = None,
  sounds = Seq.empty,
  animations = Seq.empty
)
