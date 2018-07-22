/* Generated File */
package models.data.enemy

import models.template.enemy.EnemyTemplate

object Fish extends EnemyTemplate(
  key = "fish",
  name = "Fish",
  width = 24,
  height = 24,
  hp = 1,
  damage = 10,
  isBoss = false,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = Some("acorn_squeak"),
  sounds = Seq.empty,
  animations = Seq.empty
)
