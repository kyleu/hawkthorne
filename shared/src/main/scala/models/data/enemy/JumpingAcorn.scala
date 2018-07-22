/* Generated File */
package models.data.enemy

import models.template.enemy.EnemyTemplate

object JumpingAcorn extends EnemyTemplate(
  key = "jumpingacorn",
  name = "JumpingAcorn",
  width = 20,
  height = 20,
  hp = 1,
  damage = 15,
  isBoss = false,
  passiveSound = None,
  attackSounds = Seq("acorn_growl"),
  dieSound = Some("acorn_crush"),
  sounds = Seq.empty,
  animations = Seq.empty
)
