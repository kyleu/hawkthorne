/* Generated File */
package models.data.enemy

import models.template.enemy.EnemyTemplate

object AlienTurret extends EnemyTemplate(
  key = "alien_turret",
  name = "AlienTurret",
  width = 48,
  height = 48,
  hp = 5,
  damage = 25,
  isBoss = false,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = Some("boulder-crumble"),
  sounds = Seq("alien_gatling"),
  animations = Seq.empty
)
