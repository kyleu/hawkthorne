package models.component.node

import com.definitelyscala.phaserce.{Game, Graphics, Group}
import com.definitelyscala.phasercepixi.Texture
import models.component.{BaseComponent, StaticImage}
import models.node.CeilingNode
import util.ColorUtils

object CeilingComponents {
  def apply(game: Game, group: Group, n: CeilingNode) = {
    val g = new Graphics(game = game)
    g.beginFill(ColorUtils.green.toDouble)
    g.drawRect(0, 0, n.actualWidth.toDouble, n.actualHeight.toDouble)
    val t = g.generateTexture().asInstanceOf[Texture]
    val i = StaticImage(game = game, group = group, name = s"ceiling.${n.actualName}", x = n.actualX, y = n.actualY, tex = t)
    i.image.visible = false
    Seq(i)
  }
}
