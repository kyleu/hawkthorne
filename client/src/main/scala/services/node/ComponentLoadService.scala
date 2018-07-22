package services.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.node._
import models.node._

object ComponentLoadService {
  def fromNodes(nodes: Seq[Node], game: Game, group: Group) = nodes.flatMap {
    case n: BouncerNode => BouncerComponents(game, group, n)
    case n: BreakableBlockNode => BreakableBlockComponents(game, group, n)
    case n: CauldronNode => CauldronComponents(game, group, n)
    case n: CeilingHippyNode => CeilingHippyComponents(game, group, n)
    case n: CeilingNode => CeilingComponents(game, group, n)
    case n: ClimbableNode => ClimbableComponents(game, group, n)
    case n: ConsumableNode => ConsumableComponents(game, group, n)
    case n: CorneliusHeadNode => CorneliusHeadComponents(game, group, n)
    case n: CowNode => CowComponents(game, group, n)
    case n: DealerNode => DealerComponents(game, group, n)
    case n: DetailNode => DetailComponents(game, group, n)
    case n: DoorNode => DoorComponents(game, group, n)
    case n: EnemyNode => EnemyComponents(game, group, n)
    case n: FireAlarmNode => FireAlarmComponents(game, group, n)
    case n: HeadNode => HeadComponents(game, group, n)
    case n: HiddenDoorTriggerNode => HiddenDoorTriggerComponents(game, group, n)
    case n: HSpriteNode => HSpriteComponents(game, group, n)
    case n: InfoNode => InfoComponents(game, group, n)
    case n: KeyNode => KeyComponents(game, group, n)
    case n: KillingFloorNode => KillingFloorComponents(game, group, n)
    case n: LightningNode => LightningComponents(game, group, n)
    case n: LiquidNode => LiquidComponents(game, group, n)
    case n: MailboxNode => MailboxComponents(game, group, n)
    case n: MaterialNode => MaterialComponents(game, group, n)
    case n: MovingPlatformNode => MovingPlatformComponents(game, group, n, nodes)
    case n: NpcNode => NpcComponents(game, group, n)
    case n: OvalNode => OvalComponents(game, group, n)
    case n: ProjectileNode => ProjectileComponents(game, group, n)
    case n: SavepointNode => SavepointComponents(game, group, n)
    case n: SceneTriggerNode => SceneTriggerComponents(game, group, n)
    case n: SimpleNode => SimpleComponents(game, group, n)
    case n: SparkleNode => SparkleComponents(game, group, n)
    case n: SpawnNode => SpawnComponents(game, group, n)
    case n: SplatNode => SplatComponents(game, group, n)
    case n: SpriteNode => SpriteComponents(game, group, n)
    case n: ThrowableNode => ThrowableComponents(game, group, n)
    case n: TrampolineNode => TrampolineComponents(game, group, n)
    case n: TutorialNode => TutorialComponents(game, group, n)
    case n: VehicleNode => VehicleComponents(game, group, n)
    case n: WeaponNode => WeaponComponents(game, group, n)

    case n: UnknownNode => throw new IllegalStateException(s"Unhandled [$n] component.")
  }
}
