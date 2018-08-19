package controllers.admin.activity

import controllers.BaseController
import models.Application
import models.InternalMessage.{GetSystemStatus, SystemStatus}

import scala.concurrent.Future
import akka.pattern.ask
import scala.concurrent.duration._

@javax.inject.Singleton
class ActivityController @javax.inject.Inject() (override val app: Application) extends BaseController("admin.activity") {

  import app.contexts.webContext

  def activityIndex = withSession("activity.index", admin = true) { implicit request => implicit td =>
    Future.successful(Ok(views.html.admin.activity.activityIndex(request.identity)))
  }

  def connectionList = withSession("activity.connection.list", admin = true) { implicit request => implicit td =>
    ask(app.connectionSupervisor, GetSystemStatus)(20.seconds).mapTo[SystemStatus].map { status =>
      Ok(views.html.admin.activity.connectionList(request.identity, status.connections))
    }
  }

  def gameList = withSession("activity.game.list", admin = true) { implicit request => implicit td =>
    Future.successful(Ok(views.html.admin.activity.gameList(request.identity, Nil)))
  }
}
