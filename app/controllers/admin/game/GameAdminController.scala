package controllers.admin.game

import controllers.BaseController
import models.Application
import models.data.map.TiledMap
import models.map.MapGraphData
import services.map.ServerMapCache

import scala.concurrent.Future

@javax.inject.Singleton
class GameAdminController @javax.inject.Inject() (override val app: Application) extends BaseController("admin.game") {
  import app.contexts.webContext

  def gameIndex = withSession("game.index", admin = true) { implicit request => implicit td =>
    Future.successful(Ok(views.html.admin.game.index(request.identity)))
  }

  def episodes = withSession("episodes", admin = true) { implicit request => implicit td =>
    Future.successful(Ok(views.html.admin.game.episodes(request.identity)))
  }

  def inventory = withSession("inventory", admin = true) { implicit request => implicit td =>
    Future.successful(Ok(views.html.admin.game.inventoryItems(request.identity)))
  }

  def maps = withSession("maps", admin = true) { implicit request => implicit td =>
    Future.successful(Ok(views.html.admin.game.maps(request.identity, ServerMapCache.all)))
  }

  def mapGraph() = withSession("mapGraph") { implicit request => implicit td =>
    Future.successful(Ok(views.html.admin.game.mapGraph(request.identity, MapGraphData.chartData)))
  }

  def unparsed = withSession("unparsed", admin = true) { implicit request => implicit td =>
    Future.successful(Ok(views.html.admin.game.unparsed(request.identity)))
  }

  def quests = withSession("quests", admin = true) { implicit request => implicit td =>
    Future.successful(Ok(views.html.admin.game.quests(request.identity)))
  }

  def dumpCharacters = withSession("dumpCharacters", admin = true) { implicit request => implicit td =>
    Future.successful(Ok(views.html.admin.game.dumpCharacters(request.identity)))
  }

  def dumpEnemies = withSession("dumpEnemies", admin = true) { implicit request => implicit td =>
    Future.successful(Ok(views.html.admin.game.dumpEnemies(request.identity)))
  }

  def dumpNpcs = withSession("dumpNpcs", admin = true) { implicit request => implicit td =>
    Future.successful(Ok(views.html.admin.game.dumpNpcs(request.identity)))
  }

  def dumpProjectiles = withSession("dumpProjectiles", admin = true) { implicit request => implicit td =>
    Future.successful(Ok(views.html.admin.game.dumpProjectiles(request.identity)))
  }
}
