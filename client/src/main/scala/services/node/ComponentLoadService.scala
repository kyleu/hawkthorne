package services.node

import com.definitelyscala.phaserce.{Game, Group}
import models.animation.Animation
import models.node._
import services.node.component._
import util.ColorUtils

object ComponentLoadService {
  private[this] val headAnim = Animation(id = "", frames = IndexedSeq(1, 2, 1, 2, 1, 0), delay = 0.2, loop = true)
  private[this] val sparkleAnim = Animation(id = "sparkle", frames = 0 until 4, delay = 0.3, loop = true)
  sparkleAnim.setJitter()

  def fromNodes(nodes: Seq[Node], game: Game, group: Group) = nodes.flatMap {
    case n: BouncerNode => ComponentHelper.outline(game = game, group = group, node = n, color = ColorUtils.pink, visible = false)
    case n: CeilingHippyNode => CeilingHippyComponents(game, group, n)
    case n: CeilingNode => ComponentHelper.outline(game = game, group = group, node = n, color = ColorUtils.green, visible = false)
    case n: ClimbableNode => ComponentHelper.outline(game = game, group = group, node = n, color = ColorUtils.yellow, visible = false)
    case n: ConsumableNode => ComponentHelper.cropped(game, group, n)
    case n: CorneliusHeadNode => ComponentHelper.animSingle(game, group, n, a = headAnim, key = Some("cornelius"))
    case n: DetailNode => ComponentHelper.cropped(game, group, n, key = Some(s"${n.t}.${n.properties.category}"))
    case n: DoorNode => ComponentHelper.outline(game = game, group = group, node = n, color = ColorUtils.blue, visible = false)
    case n: EnemyNode => ComponentHelper.anim(game = game, group = group, node = n, anims = n.template.animationMap, defAnim = "default.right")
    case n: FireAlarmNode => ComponentHelper.sprite(game = game, group = group, node = n, key = Some("fire.alarm"))
    case n: HiddenDoorTriggerNode => ComponentHelper.sprite(game, group, n, key = Some("hidden.door." + n.properties.sprite))
    case n: HSpriteNode => ComponentHelper.animSingle(game, group, n, a = n.animation, key = Some(n.sheetKey))
    case n: InfoNode => ComponentHelper.outline(game = game, group = group, node = n, color = ColorUtils.white, visible = false)
    case n: KeyNode => ComponentHelper.cropped(game = game, group = group, node = n)
    case n: KillingFloorNode => ComponentHelper.outline(game = game, group = group, node = n, color = ColorUtils.red, visible = false)
    case n: LiquidNode => ComponentHelper.liquid(game, group, n)
    case n: MailboxNode => ComponentHelper.outline(game = game, group = group, node = n, color = ColorUtils.white, visible = false)
    case n: MaterialNode => ComponentHelper.cropped(game, group, n)
    case n: MovingPlatformNode => MovingPlatformComponents(game, group, n, nodes)
    case n: NpcNode => ComponentHelper.anim(game = game, group = group, node = n, anims = n.template.animationMap)
    case n: ProjectileNode => ComponentHelper.anim(game = game, group = group, node = n, anims = n.template.animationMap)
    case n: SavepointNode => ComponentHelper.outline(game = game, group = group, node = n, color = ColorUtils.orange, visible = false)
    case n: SceneTriggerNode => ComponentHelper.outline(game = game, group = group, node = n, color = ColorUtils.blue, visible = false)
    case n: SimpleNode => SimpleComponents(game, group, n)
    case n: SparkleNode => ComponentHelper.animSingle(game = game, group = group, node = n, a = sparkleAnim, key = Some("cornelius.sparkle"))
    case n: SpawnNode => n.properties.sprite match {
      case Some(s) => ComponentHelper.cropped(game = game, group = group, node = n, key = Some(s"${n.t}.$s"))
      case None => ComponentHelper.outline(game = game, group = group, node = n, color = ColorUtils.purple, visible = false)
    }
    case n: SpriteNode => n.animation match {
      case Some(anim) => ComponentHelper.animSingle(game, group, n, a = anim, key = Some(n.sheetKey), flip = n.properties.flip.contains("true"))
      case None => ComponentHelper.sprite(game = game, group = group, node = n, key = Some(n.sheetKey), flip = n.properties.flip.contains("true"))
    }
    case n: TrampolineNode => ComponentHelper.outline(game = game, group = group, node = n, color = ColorUtils.pink, visible = false)
    case n: TutorialNode => ComponentHelper.outline(game = game, group = group, node = n, color = ColorUtils.white, visible = false)
    case n: UnknownNode => ComponentHelper.outline(game = game, group = group, node = n, color = 0xff0000, visible = false)
    case n: VehicleNode => ComponentHelper.anim(game = game, group = group, node = n, anims = n.template.animationMap)
    case n: WeaponNode => ComponentHelper.anim(game = game, group = group, node = n, anims = n.template.animationMap)

    case n => ComponentHelper.sprite(game = game, group = group, node = n)
  }
}
