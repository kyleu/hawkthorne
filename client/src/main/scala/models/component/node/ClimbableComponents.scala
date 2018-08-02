package models.component.node

import com.definitelyscala.phaserce.{Game, Graphics, Group}
import com.definitelyscala.phasercepixi.Texture
import models.component.StaticImage
import models.node.ClimbableNode
import util.ColorUtils

object ClimbableComponents {
  def apply(game: Game, group: Group, n: ClimbableNode) = {
    val g = new Graphics(game = game)
    g.beginFill(ColorUtils.yellow.toDouble)
    g.drawRect(0, 0, n.actualWidth.toDouble, n.actualHeight.toDouble)
    val t = g.generateTexture().asInstanceOf[Texture]
    val name = s"climbable.${n.actualName}"
    val i = StaticImage(game = game, group = group, name = name, tex = t)
    i.setPositionInt(n.actualX, n.actualY, Some(false))
    Seq(i)
  }
}
