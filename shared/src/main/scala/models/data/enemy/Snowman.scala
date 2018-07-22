/* Generated File */
package models.data.enemy

import models.template.enemy.EnemyTemplate

object Snowman extends EnemyTemplate(
  key = "snowman",
  name = "Snowman",
  width = 38,
  height = 55,
  hp = 1,
  damage = 20,
  isBoss = false,
  passiveSound = None,
  attackSounds = Seq("acorn_growl"),
  dieSound = Some("acorn_crush"),
  sounds = Seq("acorn_squeak"),
  animations = Seq.empty
)
