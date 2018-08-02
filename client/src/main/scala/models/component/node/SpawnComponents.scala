package models.component.node

import com.definitelyscala.phaserce.{Game, Graphics, Group}
import com.definitelyscala.phasercepixi.Texture
import models.component.{StaticImage, StaticSprite}
import models.node.SpawnNode
import util.ColorUtils

object SpawnComponents {
  def apply(game: Game, group: Group, n: SpawnNode) = n.properties.sprite match {
    case Some(_) =>
      val s = StaticSprite(game = game, group = group, name = "spawn." + n.actualName, key = s"spawn.${n.actualName}")
      s.setPositionInt(n.actualX, n.actualY)
      Seq(s)
    case None =>
      val g = new Graphics(game = game)
      g.beginFill(ColorUtils.purple.toDouble)
      g.drawRect(0, 0, n.actualWidth.toDouble, n.actualHeight.toDouble)
      val t = g.generateTexture().asInstanceOf[Texture]
      val name = s"spawn.${n.actualName}"
      val i = StaticImage(game = game, group = group, name = name, tex = t)
      i.setPositionInt(n.actualX, n.actualY, Some(false))
      Seq(i)
  }
}
