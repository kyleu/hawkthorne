package models.component.node

import com.definitelyscala.phaserce.{Game, Group, Rectangle}
import models.component.StaticSprite
import models.node.DetailNode

object DetailComponents {
  lazy val cropRect = new Rectangle(0, 0, 24, 24)

  def apply(game: Game, group: Group, n: DetailNode) = {
    val s = StaticSprite(game = game, group = group, name = n.actualName, x = n.actualX, y = n.actualY, key = s"detail.${n.properties.category}")
    s.sprite.cropRect = cropRect
    s.sprite.updateCrop()
    Seq(s)
  }
}
