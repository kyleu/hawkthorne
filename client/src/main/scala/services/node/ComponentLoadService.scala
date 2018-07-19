package services.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.{AnimatedSprite, StaticSprite}
import models.node.{LiquidNode, MovingPlatformNode, Node, SpriteNode}
import services.map.MapService

object ComponentLoadService {
  def fromNodes(nodes: Seq[Node], game: Game, group: Group) = nodes.flatMap {
    case n: SpriteNode => n.animation match {
      case Some(anim) =>
        val as = AnimatedSprite(game, group, (n.x * MapService.scale).toInt, (n.y * MapService.scale).toInt, n.sheetKey, Map("default" -> anim))
        as.sprite.name = n.name
        as.sprite.scale = MapService.scalePoint
        as.setAnimation(Some("default"))
        Seq(as)
      case None =>
        val staticSprite = new StaticSprite(game = game, group = group, x = n.x * MapService.scale, y = n.y * MapService.scale, key = n.sheetKey, frame = 0)
        staticSprite.sprite.name = n.name
        staticSprite.sprite.scale = MapService.scalePoint
        Seq(staticSprite)
    }
    case n: LiquidNode =>
      val as = AnimatedSprite(game, group, (n.x * MapService.scale).toInt, (n.y * MapService.scale).toInt, n.sheetKey, Map(
        "top" -> n.topAnimation, "bottom" -> n.bottomAnimation
      ))
      as.sprite.name = n.name
      as.sprite.scale = MapService.scalePoint
      as.setAnimation(Some("top"))
      Seq(as)
    case n: MovingPlatformNode =>
      val staticSprite = new StaticSprite(game = game, group = group, x = n.x * MapService.scale, y = n.y * MapService.scale, key = n.sheetKey, frame = 0)
      staticSprite.sprite.name = n.name
      staticSprite.sprite.scale = MapService.scalePoint
      Seq(staticSprite)
    case _ => Nil
  }
}
