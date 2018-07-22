/* Generated File */
package models.data.enemy

import models.template.enemy.EnemyTemplate

object GiantAcorn extends EnemyTemplate(
  key = "giantacorn",
  name = "GiantAcorn",
  width = 40,
  height = 40,
  hp = 4,
  damage = 25,
  isBoss = false,
  passiveSound = None,
  attackSounds = Seq("acorn_growl"),
  dieSound = Some("acorn_crush"),
  sounds = Seq("acorn_squeak"),
  animations = Seq.empty
)
