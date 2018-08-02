package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.StaticSprite
import models.node.SplatNode

object SplatComponents {
  def apply(game: Game, group: Group, n: SplatNode) = {
    val s = StaticSprite(game = game, group = group, name = n.actualName, key = "splat")
    s.setPositionInt(n.actualX, n.actualY)
    Seq(s)
  }
}
