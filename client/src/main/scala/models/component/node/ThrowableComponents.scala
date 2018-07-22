package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.StaticSprite
import models.node.ThrowableNode

object ThrowableComponents {
  def apply(game: Game, group: Group, n: ThrowableNode) = Seq(
    StaticSprite(game = game, group = group, name = n.actualName, x = n.actualX, y = n.actualY, key = s"throwable.${n.actualName}")
  )
}
