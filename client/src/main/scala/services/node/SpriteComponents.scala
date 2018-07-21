package services.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.{AnimatedSprite, StaticSprite}
import models.node.SpriteNode
import services.map.MapService

object SpriteComponents {
  def apply(game: Game, group: Group, n: SpriteNode) = n.animation match {
    case Some(anim) => Seq(
      AnimatedSprite(game, group, n.name, n.x * MapService.scaleInt, n.y * MapService.scaleInt, n.sheetKey, Map("default" -> anim), Some("default"))
    )
    case None =>
      val name = if (n.name.isEmpty) { n.sheetKey } else { n.name }
      Seq(StaticSprite(game = game, group = group, name = name, x = n.x * MapService.scaleInt, y = n.y * MapService.scaleInt, key = n.sheetKey))
  }
}
