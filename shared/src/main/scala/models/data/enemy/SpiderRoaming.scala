/* Generated File */
package models.data.enemy

import models.template.enemy.EnemyTemplate

object SpiderRoaming extends EnemyTemplate(
  key = "spider-roaming",
  name = "SpiderRoaming",
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
