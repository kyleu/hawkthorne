package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.StaticSprite
import models.node.CauldronNode

object CauldronComponents {
  def apply(game: Game, group: Group, n: CauldronNode) = {
    val s = StaticSprite(game = game, group = group, name = n.actualName, key = s"cauldron.${n.actualName}")
    s.setPositionInt(n.actualX, n.actualY)
    Seq(s)
  }
}
