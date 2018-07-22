/* Generated File */
package models.data.enemy

import models.template.enemy.EnemyTemplate

object Frog extends EnemyTemplate(
  key = "frog",
  name = "Frog",
  width = 48,
  height = 48,
  hp = 1,
  damage = 20,
  isBoss = false,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = Some("karramba_pop"),
  sounds = Seq.empty,
  animations = Seq.empty
)
