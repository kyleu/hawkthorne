/* Generated File */
package models.data.enemy

import models.template.enemy.EnemyTemplate

object Hemp extends EnemyTemplate(
  key = "hemp",
  name = "Hemp",
  width = 48,
  height = 48,
  hp = 1,
  damage = 20,
  isBoss = false,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = Some("hemp"),
  sounds = Seq.empty,
  animations = Seq.empty
)
