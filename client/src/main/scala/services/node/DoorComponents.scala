package services.node

import com.definitelyscala.phaserce.{Game, Graphics, Group}
import com.definitelyscala.phasercepixi.Texture
import models.component.StaticImage
import models.node.DoorNode

object DoorComponents {
  def apply(game: Game, group: Group, n: DoorNode) = {
    val g = new Graphics(game = game)
    g.beginFill(0xff0000)
    g.drawRect(0, 0, n.width.toDouble, n.height.toDouble)
    val t = g.generateTexture().asInstanceOf[Texture]
    val name = s"door.${n.name}"
    val i = StaticImage(game = game, group = group, name = name, x = n.x, y = n.y, tex = t)
    i.image.visible = false
    Seq(i)
  }
}
