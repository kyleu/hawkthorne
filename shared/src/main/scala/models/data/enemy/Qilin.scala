/* Generated File */
package models.data.enemy

import models.template.enemy.EnemyTemplate

object Qilin extends EnemyTemplate(
  key = "qilin",
  name = "Qilin",
  width = 72,
  height = 58,
  hp = 25,
  damage = 30,
  isBoss = false,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = Some("manicorn_neigh"),
  sounds = Seq.empty,
  animations = Seq.empty
)
