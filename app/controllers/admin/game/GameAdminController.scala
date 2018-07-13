package controllers.admin.game

import controllers.BaseController
import models.Application
import models.data.map.TiledMap
import models.map.ServerMap
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

  def maps = withSession("maps", admin = true) { implicit request => implicit td =>
    val serverMaps = TiledMap.values.map(tm => ServerMapCache(tm.value))
    Future.successful(Ok(views.html.admin.game.maps(request.identity, serverMaps)))
  }

  def dumpAssets = withSession("asset.dump", admin = true) { implicit request => implicit td =>
    Future.successful(Ok(views.html.admin.game.dump(request.identity)))
  }
}
