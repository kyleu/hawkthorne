package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.AnimatedSprite
import models.node.HSpriteNode

object HSpriteComponents {
  def apply(game: Game, group: Group, n: HSpriteNode) = Seq(AnimatedSprite.single(
    game = game,
    group = group,
    name = n.actualName,
    x = n.actualX,
    y = n.actualY,
    key = n.sheetKey,
    animation = n.animation
  ))
}
