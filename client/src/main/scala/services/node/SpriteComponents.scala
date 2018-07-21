package services.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.{AnimatedSprite, StaticSprite}
import models.node.SpriteNode

object SpriteComponents {
  def apply(game: Game, group: Group, n: SpriteNode) = n.animation match {
    case Some(anim) => Seq(
      AnimatedSprite(game, group, n.name, n.x, n.y, n.sheetKey, Map("default" -> anim), Some("default"))
    )
    case None =>
      val name = if (n.name.isEmpty) { n.sheetKey } else { n.name }
      Seq(StaticSprite(game = game, group = group, name = name, x = n.x, y = n.y, key = n.sheetKey))
  }
}
