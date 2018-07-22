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
      name = n.actualName,
      x = n.actualX,
      y = n.actualY,
      key = s"projectile.${n.name}",
      animation = Animation("projectile", 0 until game.cache.getFrameCount(s"projectile.${n.name}").toInt, loop = true)
    ))
  }
}
