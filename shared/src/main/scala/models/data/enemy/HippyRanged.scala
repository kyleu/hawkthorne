/* Generated File */
package models.data.enemy

import models.template.enemy.EnemyTemplate

object HippyRanged extends EnemyTemplate(
  key = "hippy-ranged",
  name = "HippyRanged",
  width = 48,
  height = 48,
  hp = 6,
  damage = 10,
  isBoss = false,
  passiveSound = None,
  attackSounds = Seq("peace", "sex", "drugs"),
  dieSound = Some("hippy_kill"),
  sounds = Seq("peace", "drugs", "sex", "throw"),
  animations = Seq.empty
)
