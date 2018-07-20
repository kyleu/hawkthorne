package services.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.StaticSprite
import models.node.MovingPlatformNode
import services.map.MapService

object MovingPlatformComponents {
  def apply(game: Game, group: Group, n: MovingPlatformNode) = {
    val name = if (n.name.isEmpty) { n.sheetKey } else { n.name }
    val staticSprite = StaticSprite(game = game, group = group, name = name, x = n.x * MapService.scale, y = n.y * MapService.scale, key = n.sheetKey)
    Seq(staticSprite)
  }
}
