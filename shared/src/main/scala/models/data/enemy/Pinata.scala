/* Generated File */
package models.data.enemy

import models.template.enemy.EnemyTemplate

object Pinata extends EnemyTemplate(
  key = "pinata",
  name = "Pinata",
  width = 19,
  height = 39,
  hp = 1,
  damage = 0,
  isBoss = false,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = Some("acorn_crush"),
  sounds = Seq.empty,
  animations = Seq.empty
)
