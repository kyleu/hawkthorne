/* Generated File */
package models.data.enemy

import models.template.enemy.EnemyTemplate

object Bat extends EnemyTemplate(
  key = "bat",
  name = "Bat",
  width = 30,
  height = 22,
  hp = 1,
  damage = 10,
  isBoss = false,
  passiveSound = None,
  attackSounds = Seq("bat_attack"),
  dieSound = Some("bat_die"),
  sounds = Seq.empty,
  animations = Seq.empty
)
