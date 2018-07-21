package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.animation.Animation
import models.component.AnimatedSprite
import models.node.ProjectileNode

object ProjectileComponents {
  def apply(game: Game, group: Group, n: ProjectileNode) = {
    Seq(AnimatedSprite.single(
      game = game,
      group = group,
      name = n.nameWithDefault,
      x = n.x,
      y = n.y,
      key = s"projectile.${n.name}",
      animation = Animation("projectile", 0 until ProjectileNode.framesFor(n.name), loop = true)
    ))
  }
}
