/* Generated File */
package models.data.enemy

import models.template.enemy.EnemyTemplate

object AmbushAlienElite extends EnemyTemplate(
  key = "ambush_alien_elite",
  name = "AmbushAlienElite",
  width = 48,
  height = 48,
  hp = 20,
  damage = 35,
  isBoss = false,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = Some("alien_hurt"),
  sounds = Seq.empty,
  animations = Seq.empty
)
