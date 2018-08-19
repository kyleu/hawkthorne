package controllers.admin.gamedata

import controllers.BaseController
import models.Application
import models.map.MapGraphData
import services.map.ServerMapCache

import scala.concurrent.Future

@javax.inject.Singleton
class GameDataController @javax.inject.Inject() (override val app: Application) extends BaseController("admin.game") {
  import app.contexts.webContext

  def dataIndex = withSession("game.index", admin = true) { implicit request => implicit td =>
    Future.successful(Ok(views.html.admin.gamedata.index(request.identity)))
  }

  def episodes = withSession("episodes", admin = true) { implicit request => implicit td =>
    Future.successful(Ok(views.html.admin.gamedata.episodes(request.identity)))
  }

  def inventory = withSession("inventory", admin = true) { implicit request => implicit td =>
    Future.successful(Ok(views.html.admin.gamedata.inventoryItems(request.identity)))
  }

  def maps = withSession("maps", admin = true) { implicit request => implicit td =>
    Future.successful(Ok(views.html.admin.gamedata.maps(request.identity, ServerMapCache.all)))
  }

  def mapGraph() = withSession("mapGraph") { implicit request => implicit td =>
    Future.successful(Ok(views.html.admin.gamedata.mapGraph(request.identity, MapGraphData.chartData)))
  }

  def unparsed = withSession("unparsed", admin = true) { implicit request => implicit td =>
    Future.successful(Ok(views.html.admin.gamedata.unparsed(request.identity)))
  }

  def quests = withSession("quests", admin = true) { implicit request => implicit td =>
    Future.successful(Ok(views.html.admin.gamedata.quests(request.identity)))
  }

  def dumpCharacters = withSession("dumpCharacters", admin = true) { implicit request => implicit td =>
    Future.successful(Ok(views.html.admin.gamedata.dumpCharacters(request.identity)))
  }

  def dumpEnemies = withSession("dumpEnemies", admin = true) { implicit request => implicit td =>
    Future.successful(Ok(views.html.admin.gamedata.dumpEnemies(request.identity)))
  }

  def dumpNpcs = withSession("dumpNpcs", admin = true) { implicit request => implicit td =>
    Future.successful(Ok(views.html.admin.gamedata.dumpNpcs(request.identity)))
  }

  def dumpProjectiles = withSession("dumpProjectiles", admin = true) { implicit request => implicit td =>
    Future.successful(Ok(views.html.admin.gamedata.dumpProjectiles(request.identity)))
  }
}
