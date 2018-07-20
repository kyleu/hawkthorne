package services.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.AnimatedSprite
import models.node.LiquidNode
import services.map.MapService

object LiquidComponents {
  def apply(game: Game, group: Group, n: LiquidNode) = {
    val name = n.name
    val as = AnimatedSprite(
      game = game, group = group, name = name, x = (n.x * MapService.scale).toInt, y = (n.y * MapService.scale).toInt, key = n.sheetKey,
      animations = Map("top" -> n.topAnimation, "bottom" -> n.bottomAnimation)
    )
    as.setAnimation(Some("top"))
    Seq(as)
  }
}
