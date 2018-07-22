/* Generated File */
package models.data.enemy

import models.template.enemy.EnemyTemplate

object AmbushAlien extends EnemyTemplate(
  key = "ambush_alien",
  name = "AmbushAlien",
  width = 29,
  height = 48,
  hp = 8,
  damage = 8,
  isBoss = false,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = Some("alien_hurt"),
  sounds = Seq.empty,
  animations = Seq.empty
)
