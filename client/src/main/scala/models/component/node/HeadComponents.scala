package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.StaticSprite
import models.node.HeadNode

object HeadComponents {
  def apply(game: Game, group: Group, n: HeadNode) = {
    val s = StaticSprite(game = game, group = group, name = "cornelius." + n.actualName, key = "cornelius.head")
    s.setPositionInt(n.actualX, n.actualY)
    Seq(s)
  }
}
