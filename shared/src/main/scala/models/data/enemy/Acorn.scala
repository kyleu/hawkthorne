/* Generated File */
package models.data.enemy

import models.template.enemy.EnemyTemplate

object Acorn extends EnemyTemplate(
  key = "acorn",
  name = "Acorn",
  width = 20,
  height = 20,
  hp = 1,
  damage = 10,
  isBoss = false,
  passiveSound = None,
  attackSounds = Seq("acorn_growl"),
  dieSound = Some("acorn_crush"),
  sounds = Seq("acorn_squeak"),
  animations = Seq.empty
)
