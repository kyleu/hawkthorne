package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.{BaseComponent, StaticSprite}
import models.node.DealerNode

object DealerComponents {
  def apply(game: Game, group: Group, n: DealerNode) = Seq(
    StaticSprite(game = game, group = group, name = n.actualName, x = n.actualX, y = n.actualY, key = "dealer")
  )
}
