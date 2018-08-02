package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.StaticSprite
import models.node.ThrowableNode

object ThrowableComponents {
  def apply(game: Game, group: Group, n: ThrowableNode) = {
    val s = StaticSprite(game = game, group = group, name = n.actualName, key = s"throwable.${n.actualName}")
    s.setPositionInt(n.actualX, n.actualY)
    Seq(s)
  }
}
