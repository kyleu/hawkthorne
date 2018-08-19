package controllers.admin.activity

import controllers.BaseController
import models.Application

import scala.concurrent.Future

@javax.inject.Singleton
class ActivityController @javax.inject.Inject() (override val app: Application) extends BaseController("admin.activity") {

  import app.contexts.webContext

  def activityIndex = withSession("activity.list", admin = true) { implicit request => implicit td =>
    Future.successful(Ok(views.html.admin.activity.activityIndex(request.identity)))
  }

  def playerList = withSession("activity.list", admin = true) { implicit request => implicit td =>
    Future.successful(Ok(views.html.admin.activity.playerList(request.identity)))
  }

  def gameList = withSession("activity.list", admin = true) { implicit request => implicit td =>
    Future.successful(Ok(views.html.admin.activity.gameList(request.identity)))
  }
}
