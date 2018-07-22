/* Generated File */
package models.data.enemy

import models.template.enemy.EnemyTemplate

object AlienElite extends EnemyTemplate(
  key = "alien_elite",
  name = "AlienElite",
  width = 48,
  height = 48,
  hp = 20,
  damage = 35,
  isBoss = false,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = Some("alien_hurt"),
  sounds = Seq.empty,
  animations = Seq.empty
)
