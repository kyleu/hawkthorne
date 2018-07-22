package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.StaticSprite
import models.node.KeyNode

object KeyComponents {
  def apply(game: Game, group: Group, n: KeyNode) = Seq(
    StaticSprite(game = game, group = group, name = n.actualName, x = n.actualX, y = n.actualY, key = s"key.${n.actualName}")
  )
}
