package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.StaticSprite
import models.node.CowNode

object CowComponents {
  def apply(game: Game, group: Group, n: CowNode) = {
    val s = StaticSprite(game = game, group = group, name = n.actualName, key = "cow")
    s.setPositionInt(n.actualX, n.actualY)
    Seq(s)
  }
}
