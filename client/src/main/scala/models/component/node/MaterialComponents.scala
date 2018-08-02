package models.component.node

import com.definitelyscala.phaserce.{Game, Group, Rectangle}
import models.component.StaticSprite
import models.node.MaterialNode

object MaterialComponents {
  lazy val cropRect = new Rectangle(0, 0, 24, 24)

  def apply(game: Game, group: Group, n: MaterialNode) = {
    val s = StaticSprite(game = game, group = group, name = "material." + n.actualName, key = s"material.${n.actualName}")
    s.setPositionInt(n.actualX, n.actualY)
    s.sprite.cropRect = cropRect
    s.sprite.updateCrop()
    Seq(s)
  }
}
