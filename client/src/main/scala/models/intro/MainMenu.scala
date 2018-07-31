package models.intro

import com.definitelyscala.phaserce.{Game, Group, Point}
import io.circe.Json
import models.analytics.AnalyticsActionType
import models.component.{Menu, StaticSprite}
import models.component.node.SparkleComponents
import models.font.Font
import models.input.{MenuAction, PointerAction}
import models.node.SparkleNode
import services.input.InputService
import services.socket.AnalyticsService
import services.state.NavigationService
import util.Logging
import util.JsonSerializers._

class MainMenu(game: Game, input: InputService, debug: Boolean) {
  private[this] val group = new Group(game = game, name = s"main.menu")
  private[this] val size = 400.0
  private[this] var zoom = 1.0
  private[this] var menuShown = false

  private[this] val background = StaticSprite(game, group, "intro.cityscape", 0, 0, "intro.cityscape")

  private[this] val logoGroup = new Group(game, group, "intro.logoGroup")
  logoGroup.scale = new Point(0.8, 0.8)
  private[this] val logo = StaticSprite(game, logoGroup, "intro.logo", 0, 0, "intro.logo")
  logo.sprite.anchor = util.PhaserUtils.centerPoint

  val sparkleCoords = Seq(55 -> 34, 42 -> 112, 132 -> 139, 271 -> 115, 274 -> 50).map { c =>
    (c._1 - (logo.sprite.width / 2).toInt - 12, c._2 - (logo.sprite.height / 2).toInt - 12)
  }
  val sparkles = sparkleCoords.zipWithIndex.map(c => SparkleNode(id = c._2, name = s"sparkle.${c._2}", x = c._1._1, y = c._1._2))
  val sparkleComponents = sparkles.flatMap(sparkle => SparkleComponents(game, logoGroup, sparkle))

  private[this] val font = Font.getFont("big", game)
  private[this] val attract = font.renderToImage(name = "attract", s = "Press Start", game = game)
  attract.anchor = util.PhaserUtils.centerPoint
  attract.position = new Point(0, background.sprite.height - 40)
  group.add(attract)

  private[this] val menu = Menu(
    game = game, name = "intro.menu", x = 0, y = background.sprite.height.toInt - 180,
    fontKey = "small", backgroundKey = "intro.menu.bg", width = 101, height = 75
  )

  group.add(menu.group)
  menu.group.visible = false
  menu.group.scale = new Point(2, 2)

  private[this] def nav(path: String) = NavigationService.navigateTo(game = game, input = input, path = path, debug = debug)
  private[this] def opts(acts: (String, String)*) = menu.setOptions(acts.map(x => (x._1, () => {
    AnalyticsService.send(AnalyticsActionType.Menu, Json.obj("key" -> x._2.asJson))
    nav(path = x._2)
  })).toIndexedSeq)
  opts("Campaign" -> "map/studyroom", "Multiplayer" -> "multiplayer", "Options" -> "options", "Credits" -> "credits", "Help" -> "help")

  NavigationService.setPath("menu")
  game.world.add(group)
  resize(game.width.toInt, game.height.toInt)

  def resize(width: Int, height: Int) = {
    zoom = Math.min(width / size, height / size)
    group.scale = new Point(zoom, zoom)
    val newY = (background.sprite.height * zoom) - height
    group.position = new Point(0.0, -newY)
    val (logoX, logoY) = ((width / 2.0) / zoom, background.sprite.height - (height / 1.4 / zoom))
    logoGroup.position = new Point(logoX, logoY)
    attract.position = new Point((width / zoom) / 2, attract.position.y)
    menu.group.position = new Point(((width / zoom) / 2) - menu.background.width, menu.group.position.y)
  }

  def update(dt: Double) = {
    sparkleComponents.foreach(_.update(dt))
    if (menuShown) {

    } else {
      attract.visible = (System.currentTimeMillis % 1000) > 400
    }
  }

  def onPointer(act: PointerAction) = if (menuShown) {
    Logging.info(s"Main menu pointer event: [$act]")
  } else {
    showMenu()
  }

  def menuActions(acts: Seq[MenuAction]) = if (menuShown) {
    menu.onMenuActions(acts)
  } else {
    showMenu()
  }

  private[this] def showMenu() = {
    if (menuShown) { throw new IllegalStateException("Double menu init") }
    menuShown = true
    attract.visible = false
    menu.group.visible = true
  }
}
