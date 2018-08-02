package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.AnimatedSprite
import models.node.EnemyNode

object EnemyComponents {
  def apply(game: Game, group: Group, n: EnemyNode) = {
    val as = AnimatedSprite(
      game = game, group = group, name = "enemy." + n.actualName, key = s"enemy.${n.sheet}",
      animations = n.template.animationMap.mapValues(_.newCopy), defAnim = Some("default.right")
    )
    as.setPositionInt(n.actualX, n.actualY)
    Seq(as)
  }
}
