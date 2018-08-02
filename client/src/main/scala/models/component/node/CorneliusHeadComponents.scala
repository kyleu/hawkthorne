package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.animation.Animation
import models.component.AnimatedSprite
import models.node.CorneliusHeadNode

object CorneliusHeadComponents {
  private[this] val anim = Animation(id = "", frames = IndexedSeq(1, 2, 1, 2, 1, 0), delay = 0.2, loop = true)

  def apply(game: Game, group: Group, n: CorneliusHeadNode) = {
    val as = AnimatedSprite.single(game = game, group = group, name = n.actualName, key = "cornelius", animation = anim.newCopy)
    as.setPositionInt(n.actualX, n.actualY)
    Seq(as)
  }
}
