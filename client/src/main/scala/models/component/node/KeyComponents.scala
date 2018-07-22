package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.{BaseComponent, StaticSprite}
import models.node.KeyNode

object KeyComponents {
  def apply(game: Game, group: Group, n: KeyNode) = Seq(
    StaticSprite(game = game, group = group, name = n.nameWithDefault, x = n.x, y = n.y, key = s"key.${n.nameWithDefault}")
  )
}
