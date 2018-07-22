/* Generated File */
package models.data.enemy

import models.template.enemy.EnemyTemplate

object Cornelius extends EnemyTemplate(
  key = "cornelius",
  name = "Cornelius",
  width = 200,
  height = 220,
  hp = 200,
  damage = 30,
  isBoss = true,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = None,
  sounds = Seq("teleport", "cornelius-ending"),
  animations = Seq.empty
)
