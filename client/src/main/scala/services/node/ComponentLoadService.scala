package services.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.node._
import models.node._

object ComponentLoadService {
  def fromNodes(nodes: Seq[Node], game: Game, group: Group) = {
    var unhandled = Set.empty[String]

    val ret = nodes.flatMap {
      case n: CauldronNode => CauldronComponents(game, group, n)
      case n: CorneliusHeadNode => CorneliusHeadComponents(game, group, n)
      case n: DoorNode => DoorComponents(game, group, n)
      case n: EnemyNode => EnemyComponents(game, group, n)
      case n: FireAlarmNode => FireAlarmComponents(game, group, n)
      case n: InfoNode => InfoComponents(game, group, n)
      case n: LiquidNode => LiquidComponents(game, group, n)
      case n: MovingPlatformNode => MovingPlatformComponents(game, group, n, nodes)
      case n: NpcNode => NpcComponents(game, group, n)
      case n: ProjectileNode => ProjectileComponents(game, group, n)
      case n: SpriteNode => SpriteComponents(game, group, n)
      case n =>
        unhandled = unhandled + n.getClass.getSimpleName
        Nil
    }
    if (unhandled.nonEmpty) {
      util.Logging.info(s"Unhandled components: ${unhandled.toSeq.sorted.mkString(", ")}")
    }
    ret
  }
}
