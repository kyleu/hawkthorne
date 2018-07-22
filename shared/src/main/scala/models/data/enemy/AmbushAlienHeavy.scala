/* Generated File */
package models.data.enemy

import models.template.enemy.EnemyTemplate

object AmbushAlienHeavy extends EnemyTemplate(
  key = "ambush_alien_heavy",
  name = "AmbushAlienHeavy",
  width = 48,
  height = 48,
  hp = 12,
  damage = 8,
  isBoss = false,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = Some("alien_hurt"),
  sounds = Seq("alien_gatling"),
  animations = Seq.empty
)
