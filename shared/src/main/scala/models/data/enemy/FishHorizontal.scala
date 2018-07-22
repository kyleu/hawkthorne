/* Generated File */
package models.data.enemy

import models.template.enemy.EnemyTemplate

object FishHorizontal extends EnemyTemplate(
  key = "fish_horizontal",
  name = "FishHorizontal",
  width = 24,
  height = 24,
  hp = 4,
  damage = 10,
  isBoss = false,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = Some("acorn_squeak"),
  sounds = Seq.empty,
  animations = Seq.empty
)
