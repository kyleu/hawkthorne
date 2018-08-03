package services.node.component

import com.definitelyscala.phaserce.{Game, Group}
import models.component.StaticSprite
import models.node.CeilingHippyNode

object CeilingHippyComponents {
  def apply(game: Game, group: Group, n: CeilingHippyNode) = {
    val name = n.actualName
    val ceiling = StaticSprite(game = game, group = group, name = s"hippy.$name.ceiling", key = s"hippy.open.ceiling")
    ceiling.setPositionInt(n.actualX, n.actualY)

    val tiles = StaticSprite(game = game, group = group, name = s"hippy.$name.tiles", key = s"hippy.broken.tiles")
    tiles.setPositionInt(n.actualX, n.actualY)

    val hippy = StaticSprite(game = game, group = group, name = s"hippy.$name", key = s"enemy.ceiling.hippy")
    hippy.setPositionInt(n.actualX, n.actualY)

    Seq(ceiling, tiles, hippy)
  }
}
