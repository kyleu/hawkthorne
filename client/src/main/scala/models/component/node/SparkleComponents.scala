package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.animation.Animation
import models.component.AnimatedSprite
import models.node.SparkleNode

object SparkleComponents {
  private[this] val anim = Animation(id = "sparkle", frames = 0 until 4, delay = 0.3, loop = true)
  anim.setJitter(1.0)

  def apply(game: Game, group: Group, n: SparkleNode) = {
    val as = AnimatedSprite.single(game = game, group = group, name = "cornelius." + n.actualName, key = "cornelius.sparkle", animation = anim.newCopy)
    as.setPositionInt(n.actualX, n.actualY)
    Seq(as)
  }
}
