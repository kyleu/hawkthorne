/* Generated File */
package models.data.enemy

import models.template.enemy.EnemyTemplate

object Manicorn extends EnemyTemplate(
  key = "manicorn",
  name = "Manicorn",
  width = 48,
  height = 48,
  hp = 13,
  damage = 40,
  isBoss = false,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = Some("manicorn_neigh"),
  sounds = Seq.empty,
  animations = Seq.empty
)
