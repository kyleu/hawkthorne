package models.component.node

import com.definitelyscala.phaserce.{Game, Graphics, Group}
import com.definitelyscala.phasercepixi.Texture
import models.component.{BaseComponent, StaticImage}
import models.node.SceneTriggerNode
import util.ColorUtils

object SceneTriggerComponents {
  def apply(game: Game, group: Group, n: SceneTriggerNode) = {
    val g = new Graphics(game = game)
    g.beginFill(ColorUtils.blue.toDouble)
    g.drawRect(0, 0, n.actualWidth.toDouble, n.actualHeight.toDouble)
    val t = g.generateTexture().asInstanceOf[Texture]
    val name = s"scene.trigger.${n.actualName}"
    val i = StaticImage(game = game, group = group, name = name, x = n.actualX, y = n.actualY, tex = t)
    i.image.visible = false
    Seq(i)
  }
}
