package models.component.node

import com.definitelyscala.phaserce.{Game, Graphics, Group}
import com.definitelyscala.phasercepixi.Texture
import models.component.StaticImage
import models.node.InfoNode

object InfoComponents {
  def apply(game: Game, group: Group, n: InfoNode) = {
    val g = new Graphics(game = game)
    g.beginFill(0x0000ff)
    g.drawRect(0, 0, n.actualWidth.toDouble, n.actualHeight.toDouble)
    val t = g.generateTexture().asInstanceOf[Texture]
    val i = StaticImage(game = game, group = group, name = s"info.${n.nameWithDefault}", x = n.x, y = n.y, tex = t)
    i.image.visible = false
    Seq(i)
  }
}
