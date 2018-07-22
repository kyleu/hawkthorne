/* Generated File */
package models.data.enemy

import models.template.enemy.EnemyTemplate

object Mannequin extends EnemyTemplate(
  key = "mannequin",
  name = "Mannequin",
  width = 48,
  height = 48,
  hp = 3,
  damage = 20,
  isBoss = false,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = Some("mannequin_death"),
  sounds = Seq.empty,
  animations = Seq.empty
)
