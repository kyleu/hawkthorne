package models.component.node

import com.definitelyscala.phaserce.{Game, Graphics, Group}
import com.definitelyscala.phasercepixi.Texture
import models.component.StaticImage
import models.node.TrampolineNode
import util.ColorUtils

object TrampolineComponents {
  def apply(game: Game, group: Group, n: TrampolineNode) = {
    val g = new Graphics(game = game)
    g.beginFill(ColorUtils.pink.toDouble)
    g.drawRect(0, 0, n.actualWidth.toDouble, n.actualHeight.toDouble)
    val t = g.generateTexture().asInstanceOf[Texture]
    val name = "trampoline"
    val i = StaticImage(game = game, group = group, name = name, tex = t)
    i.setPositionInt(n.actualX, n.actualY, Some(false))
    Seq(i)
  }
}
