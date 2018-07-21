package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.animation.Animation
import models.component.AnimatedSprite
import models.node.CorneliusHeadNode

object CorneliusHeadComponents {
  def apply(game: Game, group: Group, n: CorneliusHeadNode) = {
    Seq(AnimatedSprite(
      game = game,
      group = group,
      name = n.nameWithDefault,
      x = n.x,
      y = n.y,
      key = "cornelius",
      animations = Map("default" -> Animation(id = "", frames = IndexedSeq(1, 2, 1, 2, 1, 0), loop = true)),
      defAnim = Some("default")
    ))
  }
}
