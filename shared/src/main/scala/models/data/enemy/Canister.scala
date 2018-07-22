/* Generated File */
package models.data.enemy

import models.template.enemy.EnemyTemplate

object Canister extends EnemyTemplate(
  key = "canister",
  name = "Canister",
  width = 24,
  height = 24,
  hp = 12,
  damage = 0,
  isBoss = false,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = None,
  sounds = Seq.empty,
  animations = Seq.empty
)
