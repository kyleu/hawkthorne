/* Generated File */
package models.data.enemy

import models.template.enemy.EnemyTemplate

object AlienHeavy extends EnemyTemplate(
  key = "alien_heavy",
  name = "AlienHeavy",
  width = 48,
  height = 48,
  hp = 12,
  damage = 8,
  isBoss = false,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = Some("alien_hurt"),
  sounds = Seq("alien_gatling"),
  animations = Seq.empty
)
