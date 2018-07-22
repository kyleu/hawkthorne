/* Generated File */
package models.data.enemy

import models.template.enemy.EnemyTemplate

object Wipe extends EnemyTemplate(
  key = "wipe",
  name = "Wipe",
  width = 24,
  height = 24,
  hp = 3,
  damage = 20,
  isBoss = false,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = None,
  sounds = Seq.empty,
  animations = Seq.empty
)
