package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.StaticSprite
import models.node.EnemyNode

object EnemyComponents {
  def apply(game: Game, group: Group, n: EnemyNode) = Seq(
    StaticSprite(game = game, group = group, name = n.nameWithDefault, x = n.x, y = n.y, key = s"enemy.${n.nameWithDefault}")
  )
}
