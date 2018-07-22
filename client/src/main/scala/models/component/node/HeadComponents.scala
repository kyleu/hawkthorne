package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.{BaseComponent, StaticSprite}
import models.node.HeadNode

object HeadComponents {
  def apply(game: Game, group: Group, n: HeadNode) = Seq(
    StaticSprite(game = game, group = group, name = "cornelius." + n.actualName, x = n.actualX, y = n.actualY, key = "cornelius.head")
  )
}
