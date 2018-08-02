package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.{AnimatedSprite, StaticSprite}
import models.node.SpriteNode

object SpriteComponents {
  def apply(game: Game, group: Group, n: SpriteNode) = {
    val comp = n.animation match {
      case Some(anim) => AnimatedSprite.single(
        game = game,
        group = group,
        name = n.actualName,
        key = n.sheetKey,
        animation = anim.newCopy,
        flip = n.properties.flip.contains("true")
      )
      case None => StaticSprite(
        game = game,
        group = group,
        name = n.actualName,
        key = n.sheetKey,
        flip = n.properties.flip.contains("true")
      )
    }
    comp.setPositionInt(n.actualX, n.actualY)
    Seq(comp)

  }
}
