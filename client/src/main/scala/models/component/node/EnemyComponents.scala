package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.StaticSprite
import models.node.EnemyNode

object EnemyComponents {
  def apply(game: Game, group: Group, n: EnemyNode) = Seq(
    StaticSprite(game = game, group = group, name = "enemy." + n.actualName, x = n.actualX, y = n.actualY, key = s"enemy.${n.sheet}")
  )
}
