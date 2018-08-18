package models.game.obj

import io.circe.ObjectEncoder
import util.JsonSerializers._

object GameObjectEncoder {
  implicit val jsonEncoder: Encoder[GameObject] = new ObjectEncoder[GameObject] {
    override def encodeObject(n: GameObject) = {
      val ret = n match {
        // case o: Bouncer => o.asJson.asObject.get
        case o: BreakableBlock => o.asJson.asObject.get
        // case o: Building => o.asJson.asObject.get
        case o: Cauldron => o.asJson.asObject.get
        // case o: Ceiling => o.asJson.asObject.get
        // case o: CeilingHippy => o.asJson.asObject.get
        case o: Climbable => o.asJson.asObject.get
        case o: Consumable => o.asJson.asObject.get
        // case o: CorneliusHead => o.asJson.asObject.get
        // case o: Cow => o.asJson.asObject.get
        // case o: Dealer => o.asJson.asObject.get
        // case o: Detail => o.asJson.asObject.get
        case o: Door => o.asJson.asObject.get
        case o: Enemy => o.asJson.asObject.get
        case o: FireAlarm => o.asJson.asObject.get
        // case o: Head => o.asJson.asObject.get
        // case o: HiddenDoorTrigger => o.asJson.asObject.get
        // case o: HSprite => o.asJson.asObject.get
        case o: Info => o.asJson.asObject.get
        case o: Key => o.asJson.asObject.get
        case o: KillingFloor => o.asJson.asObject.get
        // case o: Lightning => o.asJson.asObject.get
        // case o: Liquid => o.asJson.asObject.get
        // case o: Mailbox => o.asJson.asObject.get
        case o: Material => o.asJson.asObject.get
        case o: MovingPlatform => o.asJson.asObject.get
        case o: Npc => o.asJson.asObject.get
        // case o: Oval => o.asJson.asObject.get
        case o: Projectile => o.asJson.asObject.get
        case o: Savepoint => o.asJson.asObject.get
        case o: SceneTrigger => o.asJson.asObject.get
        // case o: Simple => o.asJson.asObject.get
        // case o: Sparkle => o.asJson.asObject.get
        case o: Spawn => o.asJson.asObject.get
        // case o: Splat => o.asJson.asObject.get
        // case o: Sprite => o.asJson.asObject.get
        // case o: Throwable => o.asJson.asObject.get
        // case o: Trampoline => o.asJson.asObject.get
        // case o: Tutorial => o.asJson.asObject.get
        case o: Vehicle => o.asJson.asObject.get
        case o: Weapon => o.asJson.asObject.get
        case o: WorkInProgress => o.asJson.asObject.get
        // case o: Unknown => o.asJson.asObject.get
      }
      ("type" -> n.t.asJson) +: ret
    }
  }
}
