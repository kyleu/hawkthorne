package models.component.node

import com.definitelyscala.phaserce.{Game, Graphics, Group}
import com.definitelyscala.phasercepixi.Texture
import models.component.StaticImage
import models.node.UnknownNode

object UnknownComponents {
  def apply(game: Game, group: Group, n: UnknownNode) = {
    val g = new Graphics(game = game)
    g.beginFill(0xff0000)
    g.drawRect(0, 0, n.actualWidth.toDouble, n.actualHeight.toDouble)
    val t = g.generateTexture().asInstanceOf[Texture]
    val name = s"unknown.${n.actualName}"
    val i = StaticImage(game = game, group = group, name = name, x = n.actualX, y = n.actualY, tex = t)
    Seq(i)
  }
}
