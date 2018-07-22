/* Generated File */
package models.data.enemy

import models.template.enemy.EnemyTemplate

object Wasabi extends EnemyTemplate(
  key = "wasabi",
  name = "Wasabi",
  width = 36,
  height = 36,
  hp = 8,
  damage = 30,
  isBoss = false,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = Some("acorn_crush"),
  sounds = Seq.empty,
  animations = Seq.empty
)
