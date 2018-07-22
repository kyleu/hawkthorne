/* Generated File */
package models.data.enemy

import models.template.enemy.EnemyTemplate

object RubberSpider extends EnemyTemplate(
  key = "rubberspider",
  name = "RubberSpider",
  width = 24,
  height = 24,
  hp = 100000,
  damage = 0,
  isBoss = false,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = Some("boing"),
  sounds = Seq.empty,
  animations = Seq.empty
)
