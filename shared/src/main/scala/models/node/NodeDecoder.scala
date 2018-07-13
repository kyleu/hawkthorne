package models.node

import io.circe.{HCursor, JsonObject}
import util.JsonSerializers._

object NodeDecoder {
  implicit val jsonDecoder: Decoder[Node] = (c: HCursor) => c.downField("type").as[String].right.get match {
    case BouncerNode.key => c.as[BouncerNode]
    case BreakableBlockNode.key => c.as[BreakableBlockNode]
    case BuildingNode.key => c.as[BuildingNode]
    case CauldronNode.key => c.as[CauldronNode]
    case CeilingNode.key => c.as[CeilingNode]
    case CeilingHippyNode.key => c.as[CeilingHippyNode]
    case ClimbableNode.key => c.as[ClimbableNode]
    case ConsumableNode.key => c.as[ConsumableNode]
    case CorneliusHeadNode.key => c.as[CorneliusHeadNode]
    case CowNode.key => c.as[CowNode]
    case DealerNode.key => c.as[DealerNode]
    case DetailNode.key => c.as[DetailNode]
    case DoorNode.key => c.as[DoorNode]
    case EnemyNode.key => c.as[EnemyNode]
    case FireAlarmNode.key => c.as[FireAlarmNode]
    case HeadNode.key => c.as[HeadNode]
    case HiddenDoorTriggerNode.key => c.as[HiddenDoorTriggerNode]
    case HSpriteNode.key => c.as[HSpriteNode]
    case InfoNode.key => c.as[InfoNode]
    case KeyNode.key => c.as[KeyNode]
    case KillingFloorNode.key => c.as[KillingFloorNode]
    case LightningNode.key => c.as[LightningNode]
    case LiquidNode.key => c.as[LiquidNode]
    case MailboxNode.key => c.as[MailboxNode]
    case MaterialNode.key => c.as[MaterialNode]
    case MovingPlatformNode.key => c.as[MovingPlatformNode]
    case NpcNode.key => c.as[NpcNode]
    case OvalNode.key => c.as[OvalNode]
    case ProjectileNode.key => c.as[ProjectileNode]
    case SavepointNode.key => c.as[SavepointNode]
    case SceneTriggerNode.key => c.as[SceneTriggerNode]
    case SimpleNode.key => c.as[SimpleNode]
    case SparkleNode.key => c.as[SparkleNode]
    case SpawnNode.key => c.as[SpawnNode]
    case SplatNode.key => c.as[SplatNode]
    case SpriteNode.key => c.as[SpriteNode]
    case ThrowableNode.key => c.as[ThrowableNode]
    case TrampolineNode.key => c.as[TrampolineNode]
    case TutorialNode.key => c.as[TutorialNode]
    case VehicleNode.key => c.as[VehicleNode]
    case WeaponNode.key => c.as[WeaponNode]
    case "" => c.as[SimpleNode]
    case x => Right(UnknownNode(x, c.as[JsonObject].right.get))
  }
}
