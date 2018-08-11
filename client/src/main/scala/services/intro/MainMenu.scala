package services.intro

import com.definitelyscala.phaserce.{Game, Group, Point}
import io.circe.Json
import models.analytics.AnalyticsActionType
import models.component.StaticSprite
import models.font.Font
import models.gui.Menu
import models.input.{MenuAction, PointerAction}
import models.node.SparkleNode
import services.input.InputService
import services.node.ComponentLoadService
import services.socket.AnalyticsService
import services.state.NavigationService
import util.JsonSerializers._

class MainMenu(game: Game, input: InputService, debug: Boolean) {
  private[this] val group = new Group(game = game, name = s"main.menu")
  private[this] val size = 400.0
  private[this] var zoom = 1.0
  private[this] var menuShown = false

  private[this] val background = StaticSprite(game, group, "intro.cityscape", "intro.cityscape")

  private[this] val logoGroup = new Group(game, group, "intro.logoGroup")
  logoGroup.scale.set(0.8, 0.8)
  private[this] val logo = StaticSprite(game, logoGroup, "intro.logo", "intro.logo")
  logo.sprite.anchor.set(0.5, 0.5)

  val sparkleCoords = Seq(55 -> 34, 42 -> 112, 132 -> 139, 271 -> 115, 274 -> 50).map { c =>
    (c._1 - (logo.sprite.width / 2).toInt - 12, c._2 - (logo.sprite.height / 2).toInt - 12)
  }
  val sparkles = sparkleCoords.zipWithIndex.map(c => SparkleNode(id = c._2, name = s"sparkle.${c._2}", x = c._1._1, y = c._1._2))
  val sparkleComponents = ComponentLoadService.fromNodes(sparkles, game, logoGroup)

  private[this] val font = Font.getFont("big", game)
  private[this] val attract = font.render(name = "attract", text = "Press Start", game = game, y = background.sprite.height - 40.0)
  group.add(attract.group)

  private[this] val menu = Menu(
    game = game, name = "intro.menu", fontKey = "small", arrowKey = "intro.menu.arrow", backgroundKey = "intro.menu.bg", width = 101, height = 75
  )
  menu.y = background.sprite.height.toInt - 180.0
  menu.visible = false
  menu.group.scale.set(2.0, 2.0)
  group.add(menu.group)

  private[this] def nav(path: String) = NavigationService.navigateTo(game = game, input = input, path = path, debug = debug)
  private[this] def actions(acts: (String, String)*) = acts.map(x => (x._1, () => {
    AnalyticsService.send(AnalyticsActionType.Menu, Json.obj("key" -> x._2.asJson))
    nav(path = x._2)
  })).toIndexedSeq
  val acts = actions("Campaign" -> "map/studyroom", "Multiplayer" -> "multiplayer", "Options" -> "options", "Credits" -> "credits", "Help" -> "help")
  menu.setOptions(acts)

  NavigationService.setPath("menu")
  game.world.add(group)
  resize(game.width.toInt, game.height.toInt)

  def resize(width: Int, height: Int) = {
    zoom = Math.min(width / size, height / size)
    group.scale.set(zoom, zoom)
    val newY = (background.sprite.height * zoom) - height
    group.position = new Point(0.0, -newY)
    val (logoX, logoY) = ((width / 2.0) / zoom, background.sprite.height - (height / 1.4 / zoom))
    logoGroup.position.set(logoX, logoY)
    attract.group.position.set(((width / zoom) - attract.group.width) / 2, attract.group.position.y)
    menu.group.position.set(((width / zoom) / 2) - menu.background.width, menu.group.position.y)
  }

  def update(dt: Double) = {
    sparkleComponents.foreach(_.update(dt))
    if (!menuShown) {
      attract.group.visible = (System.currentTimeMillis % 1000) > 400
    }
  }

  def onPointer(act: PointerAction) = if (menuShown) {
    menu.onPointer(act = act, zoom = zoom, scaleMultiplier = 2)
  } else {
    showMenu()
  }

  def menuActions(acts: Seq[MenuAction]) = if (menuShown) {
    acts.foreach(menu.onMenuAction)
  } else {
    showMenu()
  }

  private[this] def showMenu() = {
    if (menuShown) { throw new IllegalStateException("Double menu init") }
    menuShown = true
    attract.group.visible = false
    menu.group.visible = true
  }
}
