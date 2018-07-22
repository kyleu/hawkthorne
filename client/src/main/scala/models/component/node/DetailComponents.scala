package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.StaticSprite
import models.node.DetailNode

object DetailComponents {
  def apply(game: Game, group: Group, n: DetailNode) = Seq(
    StaticSprite(game = game, group = group, name = n.actualName, x = n.actualX, y = n.actualY, key = s"detail.${n.properties.category}")
  )
}
