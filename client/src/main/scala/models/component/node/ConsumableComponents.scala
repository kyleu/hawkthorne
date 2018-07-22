package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.StaticSprite
import models.node.ConsumableNode

object ConsumableComponents {
  def apply(game: Game, group: Group, n: ConsumableNode) = Seq(
    StaticSprite(game = game, group = group, name = "consumable." + n.actualName, x = n.actualX, y = n.actualY, key = s"consumable.${n.actualName}")
  )
}
