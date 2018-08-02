package models.component.node

import com.definitelyscala.phaserce.{Game, Graphics, Group}
import com.definitelyscala.phasercepixi.Texture
import models.component.StaticImage
import models.node.BouncerNode
import util.ColorUtils

object BouncerComponents {
  def apply(game: Game, group: Group, n: BouncerNode) = {
    val g = new Graphics(game = game)
    g.beginFill(ColorUtils.pink.toDouble)
    g.drawRect(0, 0, n.actualWidth.toDouble, n.actualHeight.toDouble)
    val t = g.generateTexture().asInstanceOf[Texture]
    val name = s"bouncer.${n.actualName}"
    val i = StaticImage(game = game, group = group, name = name, tex = t)
    i.setPositionInt(n.actualX, n.actualY, Some(false))
    Seq(i)
  }
}
