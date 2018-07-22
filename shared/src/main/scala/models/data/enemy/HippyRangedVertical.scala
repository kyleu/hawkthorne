/* Generated File */
package models.data.enemy

import models.template.enemy.EnemyTemplate

object HippyRangedVertical extends EnemyTemplate(
  key = "hippy-ranged-vertical",
  name = "HippyRangedVertical",
  width = 48,
  height = 48,
  hp = 6,
  damage = 10,
  isBoss = false,
  passiveSound = None,
  attackSounds = Seq("peace", "sex", "drugs"),
  dieSound = Some("hippy_kill"),
  sounds = Seq.empty,
  animations = Seq.empty
)
