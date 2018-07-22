/* Generated File */
package models.data.enemy

import models.template.enemy.EnemyTemplate

object Spider extends EnemyTemplate(
  key = "spider",
  name = "Spider",
  width = 48,
  height = 48,
  hp = 12,
  damage = 20,
  isBoss = false,
  passiveSound = Some("spider-growl"),
  attackSounds = Nil,
  dieSound = Some("acorn_crush"),
  sounds = Seq.empty,
  animations = Seq.empty
)
