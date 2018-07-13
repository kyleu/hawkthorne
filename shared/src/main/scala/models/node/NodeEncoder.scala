package models.node

import io.circe.ObjectEncoder
import util.JsonSerializers._

object NodeEncoder {
  implicit val jsonEncoder: Encoder[Node] = new ObjectEncoder[Node] {
    override def encodeObject(n: Node) = {
      val ret = n match {
        case o: BouncerNode => o.asJson.asObject.get
        case o: BreakableBlockNode => o.asJson.asObject.get
        case o: BuildingNode => o.asJson.asObject.get
        case o: CauldronNode => o.asJson.asObject.get
        case o: CeilingNode => o.asJson.asObject.get
        case o: CeilingHippyNode => o.asJson.asObject.get
        case o: ClimbableNode => o.asJson.asObject.get
        case o: ConsumableNode => o.asJson.asObject.get
        case o: CorneliusHeadNode => o.asJson.asObject.get
        case o: CowNode => o.asJson.asObject.get
        case o: DealerNode => o.asJson.asObject.get
        case o: DetailNode => o.asJson.asObject.get
        case o: DoorNode => o.asJson.asObject.get
        case o: EnemyNode => o.asJson.asObject.get
        case o: FireAlarmNode => o.asJson.asObject.get
        case o: HeadNode => o.asJson.asObject.get
        case o: HiddenDoorTriggerNode => o.asJson.asObject.get
        case o: HSpriteNode => o.asJson.asObject.get
        case o: InfoNode => o.asJson.asObject.get
        case o: KeyNode => o.asJson.asObject.get
        case o: KillingFloorNode => o.asJson.asObject.get
        case o: LightningNode => o.asJson.asObject.get
        case o: LiquidNode => o.asJson.asObject.get
        case o: MailboxNode => o.asJson.asObject.get
        case o: MaterialNode => o.asJson.asObject.get
        case o: MovingPlatformNode => o.asJson.asObject.get
        case o: NpcNode => o.asJson.asObject.get
        case o: OvalNode => o.asJson.asObject.get
        case o: ProjectileNode => o.asJson.asObject.get
        case o: SavepointNode => o.asJson.asObject.get
        case o: SceneTriggerNode => o.asJson.asObject.get
        case o: SimpleNode => o.asJson.asObject.get
        case o: SparkleNode => o.asJson.asObject.get
        case o: SpawnNode => o.asJson.asObject.get
        case o: SplatNode => o.asJson.asObject.get
        case o: SpriteNode => o.asJson.asObject.get
        case o: ThrowableNode => o.asJson.asObject.get
        case o: TrampolineNode => o.asJson.asObject.get
        case o: TutorialNode => o.asJson.asObject.get
        case o: VehicleNode => o.asJson.asObject.get
        case o: WeaponNode => o.asJson.asObject.get
        case o: UnknownNode => o.asJson.asObject.get
      }
      ("type" -> n.t.asJson) +: ret
    }
  }
}
