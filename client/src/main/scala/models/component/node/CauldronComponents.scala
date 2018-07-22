package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.StaticSprite
import models.node.CauldronNode

object CauldronComponents {
  def apply(game: Game, group: Group, n: CauldronNode) = {
    val sprite = StaticSprite(game = game, group = group, name = n.actualName, x = n.actualX, y = n.actualY, key = s"cauldron.${n.actualName}")
    Seq(sprite)
  }
}
