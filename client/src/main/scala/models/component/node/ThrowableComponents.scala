package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.{BaseComponent, StaticSprite}
import models.node.ThrowableNode

object ThrowableComponents {
  def apply(game: Game, group: Group, n: ThrowableNode) = Seq(
    StaticSprite(game = game, group = group, name = n.nameWithDefault, x = n.x, y = n.y, key = s"throwable.${n.nameWithDefault}")
  )
}
