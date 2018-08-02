package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.StaticSprite
import models.node.{MovingPlatformNode, Node, SimpleNode}

object MovingPlatformComponents {
  def apply(game: Game, group: Group, n: MovingPlatformNode, nodes: Seq[Node]) = {
    val chainLength = n.properties.chain.map(_.toInt).getOrElse(1)
    val sprites = (0 until chainLength).map { idx =>
      val s = StaticSprite(game = game, group = group, name = s"${n.actualName}.$idx", key = n.sheetKey)
      s.setPositionInt(n.actualX + (n.actualWidth * idx), n.actualY)
      s
    }

    val lineNode = nodes.collectFirst {
      case s: SimpleNode if s.name == n.properties.line => s
    }.getOrElse(throw new IllegalStateException(s"Cannot find simple node for referenced line [${n.properties.line}]."))

    lineNode.polyline.getOrElse(throw new IllegalStateException(s"Line [${lineNode.name}] has no defined points."))

    sprites
  }
}
