package services.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.{AnimatedSprite, StaticSprite}
import models.node.SpriteNode
import services.map.MapService

object SpriteComponents {
  def apply(game: Game, group: Group, n: SpriteNode) = n.animation match {
    case Some(anim) =>
      val as = AnimatedSprite(game, group, n.name, (n.x * MapService.scale).toInt, (n.y * MapService.scale).toInt, n.sheetKey, Map("default" -> anim))
      as.setAnimation(Some("default"))
      Seq(as)
    case None =>
      val name = if (n.name.isEmpty) { n.sheetKey } else { n.name }
      val staticSprite = StaticSprite(game = game, group = group, name = name, x = n.x * MapService.scale, y = n.y * MapService.scale, key = n.sheetKey)
      Seq(staticSprite)
  }
}
