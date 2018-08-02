package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.AnimatedSprite
import models.node.HSpriteNode

object HSpriteComponents {
  def apply(game: Game, group: Group, n: HSpriteNode) = {
    val as = AnimatedSprite.single(game = game, group = group, name = n.actualName, key = n.sheetKey, animation = n.animation)
    as.setPositionInt(n.actualX, n.actualY)
    Seq(as)
  }
}
