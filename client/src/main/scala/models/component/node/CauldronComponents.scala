package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.StaticSprite
import models.node.CauldronNode

object CauldronComponents {
  def apply(game: Game, group: Group, n: CauldronNode) = {
    val sprite = StaticSprite(game = game, group = group, name = n.name, x = n.x, y = n.y, key = s"cauldron.${n.name}")
    Seq(sprite)
  }
}
