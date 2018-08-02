package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.StaticSprite
import models.node.KeyNode

object KeyComponents {
  def apply(game: Game, group: Group, n: KeyNode) = {
    val s = StaticSprite(game = game, group = group, name = n.actualName, key = s"key.${n.actualName}")
    s.setPositionInt(n.actualX, n.actualY)
    Seq(s)
  }
}
