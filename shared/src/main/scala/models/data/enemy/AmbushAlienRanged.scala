/* Generated File */
package models.data.enemy

import models.template.enemy.EnemyTemplate

object AmbushAlienRanged extends EnemyTemplate(
  key = "ambush_alien_ranged",
  name = "AmbushAlienRanged",
  width = 48,
  height = 48,
  hp = 14,
  damage = 25,
  isBoss = false,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = Some("alien_hurt"),
  sounds = Seq("alien_laser"),
  animations = Seq.empty
)
