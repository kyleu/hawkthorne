package models.component.node

import com.definitelyscala.phaserce.{Game, Graphics, Group}
import com.definitelyscala.phasercepixi.Texture
import models.component.{StaticImage, StaticSprite}
import models.node.SpawnNode
import util.ColorUtils

object SpawnComponents {
  def apply(game: Game, group: Group, n: SpawnNode) = n.properties.sprite match {
    case Some(_) => Seq(StaticSprite(game = game, group = group, name = "spawn." + n.actualName, x = n.actualX, y = n.actualY, key = s"spawn.${n.actualName}"))
    case None =>
      val g = new Graphics(game = game)
      g.beginFill(ColorUtils.purple.toDouble)
      g.drawRect(0, 0, n.actualWidth.toDouble, n.actualHeight.toDouble)
      val t = g.generateTexture().asInstanceOf[Texture]
      val name = s"spawn.${n.actualName}"
      val i = StaticImage(game = game, group = group, name = name, x = n.actualX, y = n.actualY, tex = t)
      i.image.visible = false
      Seq(i)
  }
}
