/* Generated File */
package models.data.enemy

import models.template.enemy.EnemyTemplate

object AlienRanged extends EnemyTemplate(
  key = "alien_ranged",
  name = "AlienRanged",
  width = 48,
  height = 48,
  hp = 14,
  damage = 25,
  isBoss = false,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = Some("alien_hurt"),
  sounds = Seq("alien_laser"),
  animations = Seq.empty
)
