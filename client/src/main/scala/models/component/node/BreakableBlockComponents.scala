package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.StaticSprite
import models.node.BreakableBlockNode

object BreakableBlockComponents {
  def apply(game: Game, group: Group, n: BreakableBlockNode) = Seq(
    StaticSprite(game = game, group = group, name = "block." + n.actualName, x = n.actualX, y = n.actualY, key = s"block.${n.actualName}")
  )
}
