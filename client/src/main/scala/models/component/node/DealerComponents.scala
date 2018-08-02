package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.StaticSprite
import models.node.DealerNode

object DealerComponents {
  def apply(game: Game, group: Group, n: DealerNode) = {
    val s = StaticSprite(game = game, group = group, name = n.actualName, key = "dealer")
    s.setPositionInt(n.actualX, n.actualY)
    Seq(s)
  }
}
