package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.LiquidComponent
import models.node.LiquidNode

object LiquidComponents {
  def apply(game: Game, group: Group, n: LiquidNode) = {
    val name = if (n.name.isEmpty) { s"liquid.${n.id}" } else { n.name }
    Seq(LiquidComponent(
      game = game,
      group = group,
      name = name,
      key = n.sheetKey,
      x = n.x,
      y = n.y,
      opacity = n.opacityDouble,
      width = n.width / 24,
      height = n.height / 24
    ))
  }
}
