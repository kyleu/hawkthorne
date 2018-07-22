/* Generated File */
package models.data.enemy

import models.template.enemy.EnemyTemplate

object Humbug extends EnemyTemplate(
  key = "humbug",
  name = "Humbug",
  width = 58,
  height = 40,
  hp = 1,
  damage = 10,
  isBoss = false,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = Some("acorn_crush"),
  sounds = Seq.empty,
  animations = Seq.empty
)
