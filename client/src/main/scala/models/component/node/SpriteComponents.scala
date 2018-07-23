package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.{AnimatedSprite, StaticSprite}
import models.node.SpriteNode

object SpriteComponents {
  def apply(game: Game, group: Group, n: SpriteNode) = n.animation match {
    case Some(anim) => Seq(AnimatedSprite.single(
      game = game,
      group = group,
      name = n.actualName,
      x = n.actualX,
      y = n.actualY,
      key = n.sheetKey,
      animation = anim.newCopy,
      flip = n.properties.flip.contains("true")
    ))
    case None => Seq(StaticSprite(
      game = game,
      group = group,
      name = n.actualName,
      x = n.actualX,
      y = n.actualY,
      key = n.sheetKey,
      flip = n.properties.flip.contains("true")
    ))
  }
}
