/* Generated File */
package models.data.enemy

import models.template.enemy.EnemyTemplate

object Trombonist extends EnemyTemplate(
  key = "trombonist",
  name = "Trombonist",
  width = 58,
  height = 39,
  hp = 8,
  damage = 20,
  isBoss = false,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = Some("trombone_temp"),
  sounds = Seq.empty,
  animations = Seq.empty
)
