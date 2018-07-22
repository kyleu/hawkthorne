/* Generated File */
package models.data.enemy

import models.template.enemy.EnemyTemplate

object AcornPod extends EnemyTemplate(
  key = "acornpod",
  name = "AcornPod",
  width = 24,
  height = 24,
  hp = 1000,
  damage = 5,
  isBoss = false,
  passiveSound = None,
  attackSounds = Nil,
  dieSound = None,
  sounds = Seq.empty,
  animations = Seq.empty
)
