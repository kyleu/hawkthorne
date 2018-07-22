package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.{BaseComponent, StaticSprite}
import models.node.CeilingHippyNode

object CeilingHippyComponents {
  def apply(game: Game, group: Group, n: CeilingHippyNode) = {
    val name = n.actualName
    val ceiling = StaticSprite(game = game, group = group, name = s"hippy.$name.ceiling", x = n.actualX, y = n.actualY, key = s"hippy.open.ceiling")
    val tiles = StaticSprite(game = game, group = group, name = s"hippy.$name.tiles", x = n.actualX, y = n.actualY, key = s"hippy.broken.tiles")
    val hippy = StaticSprite(game = game, group = group, name = s"hippy.$name", x = n.actualX, y = n.actualY, key = s"enemy.ceiling.hippy")

    Seq(ceiling, tiles, hippy)
  }
}
