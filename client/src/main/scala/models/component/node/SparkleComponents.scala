package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.StaticSprite
import models.node.SparkleNode

object SparkleComponents {
  def apply(game: Game, group: Group, n: SparkleNode) = Seq(
    StaticSprite(game = game, group = group, name = "cornelius." + n.actualName, x = n.actualX, y = n.actualY, key = "cornelius.sparkle")
  )
}
