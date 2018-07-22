/* Generated File */
package models.data.enemy

import models.template.enemy.EnemyTemplate

object Hippy extends EnemyTemplate(
  key = "hippy",
  name = "Hippy",
  width = 48,
  height = 48,
  hp = 6,
  damage = 10,
  isBoss = false,
  passiveSound = Some("peace"),
  attackSounds = Seq("sex", "drugs"),
  dieSound = Some("hippy_kill"),
  sounds = Seq.empty,
  animations = Seq.empty
)
