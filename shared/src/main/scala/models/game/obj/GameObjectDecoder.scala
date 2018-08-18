package models.game.obj

import io.circe.{HCursor, JsonObject}
import util.JsonSerializers._

object GameObjectDecoder {
  implicit val jsonDecoder: Decoder[GameObject] = (c: HCursor) => c.downField("type").as[String] match {
    case Left(x) => throw new IllegalStateException(s"Unable to find [type] among [${c.keys.mkString(", ")}].", x)
    case Right(t) => t match {
      // case Bouncer.key => c.as[Bouncer]
      case BreakableBlock.key => c.as[BreakableBlock]
      // case Building.key => c.as[Building]
      case Cauldron.key => c.as[Cauldron]
      // case Ceiling.key => c.as[Ceiling]
      // case CeilingHippy.key => c.as[CeilingHippy]
      case Climbable.key => c.as[Climbable]
      case Consumable.key => c.as[Consumable]
      // case CorneliusHead.key => c.as[CorneliusHead]
      // case Cow.key => c.as[Cow]
      // case Dealer.key => c.as[Dealer]
      // case Detail.key => c.as[Detail]
      case Door.key => c.as[Door]
      case Enemy.key => c.as[Enemy]
      case FireAlarm.key => c.as[FireAlarm]
      // case Head.key => c.as[Head]
      // case HiddenDoorTrigger.key => c.as[HiddenDoorTrigger]
      // case HSprite.key => c.as[HSprite]
      case Info.key => c.as[Info]
      case Key.key => c.as[Key]
      case KillingFloor.key => c.as[KillingFloor]
      // case Lightning.key => c.as[Lightning]
      // case Liquid.key => c.as[Liquid]
      // case Mailbox.key => c.as[Mailbox]
      case Material.key => c.as[Material]
      case MovingPlatform.key => c.as[MovingPlatform]
      case Npc.key => c.as[Npc]
      // case Oval.key => c.as[Oval]
      case Projectile.key => c.as[Projectile]
      case Savepoint.key => c.as[Savepoint]
      case SceneTrigger.key => c.as[SceneTrigger]
      // case Simple.key => c.as[Simple]
      // case Sparkle.key => c.as[Sparkle]
      case Spawn.key => c.as[Spawn]
      // case Splat.key => c.as[Splat]
      // case Sprite.key => c.as[Sprite]
      // case Throwable.key => c.as[Throwable]
      // case Trampoline.key => c.as[Trampoline]
      // case Tutorial.key => c.as[Tutorial]
      case Vehicle.key => c.as[Vehicle]
      case Weapon.key => c.as[Weapon]
      case WorkInProgress.key => c.as[WorkInProgress]
      // case "" => c.as[Simple]
      case _ => throw new IllegalStateException(s"Cannot decode type [$t]")
    }
  }
}
