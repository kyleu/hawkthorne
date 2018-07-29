package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.LiquidComponent
import models.node.LiquidNode

object LiquidComponents {
  def apply(game: Game, group: Group, n: LiquidNode) = {
    Seq(LiquidComponent(
      game = game,
      group = group,
      name = "liquid." + n.actualName,
      key = n.sheetKey,
      x = n.actualX,
      y = n.actualY,
      opacity = n.opacityDouble,
      speed = n.properties.speed.map(_.toDouble).getOrElse(0.2),
      width = n.actualWidth / 24,
      height = n.actualHeight / 24
    ))
  }
}
