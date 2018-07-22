package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.animation.Animation
import models.component.AnimatedSprite
import models.node.CorneliusHeadNode

object CorneliusHeadComponents {
  def apply(game: Game, group: Group, n: CorneliusHeadNode) = Seq(AnimatedSprite.single(
    game = game,
    group = group,
    name = n.actualName,
    x = n.actualX,
    y = n.actualY,
    key = "cornelius",
    animation = Animation(id = "", frames = IndexedSeq(1, 2, 1, 2, 1, 0), delay = 0.2, loop = true)
  ))
}
