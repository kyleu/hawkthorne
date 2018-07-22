/* Generated File */
package models.data.enemy

import models.template.enemy.EnemyTemplate

object Penguin extends EnemyTemplate(
  key = "penguin",
  name = "Penguin",
  width = 40,
  height = 20,
  hp = 1,
  damage = 0,
  isBoss = false,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = Some("acorn_crush"),
  sounds = Seq.empty,
  animations = Seq.empty
)
