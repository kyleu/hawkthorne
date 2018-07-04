package controllers.admin.game

import controllers.BaseController
import models.Application

import scala.concurrent.Future

@javax.inject.Singleton
class GameAdminController @javax.inject.Inject() (override val app: Application) extends BaseController("admin.game") {
  import app.contexts.webContext

  def gameIndex = withSession("game.index", admin = true) { implicit request => implicit td =>
    Future.successful(Ok(views.html.admin.game.index(request.identity)))
  }

  def dumpAssets = withSession("asset.dump", admin = true) { implicit request => implicit td =>
    Future.successful(Ok(views.html.admin.game.dump(request.identity)))
  }
}
