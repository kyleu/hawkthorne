package controllers.admin.activity

import controllers.BaseController
import models.{Application, ResponseMessage}
import models.InternalMessage.{GetSystemStatus, SystemStatus}

import scala.concurrent.Future
import akka.pattern.ask
import services.supervisor.ConnectionSupervisor

import scala.concurrent.duration._

@javax.inject.Singleton
class ActivityController @javax.inject.Inject() (override val app: Application) extends BaseController("admin.activity") {

  import app.contexts.webContext

  def activityIndex = withSession("activity.index", admin = true) { implicit request => implicit td =>
    Future.successful(Ok(views.html.admin.activity.activityIndex(request.identity)))
  }

  def broadcast(msg: Option[String]) = withSession("activity.broadcast", admin = true) { implicit request => implicit td =>
    msg.map(_.trim) match {
      case None => throw new IllegalStateException("Must provide \"msg\" parameter.")
      case Some(message) if message.isEmpty => throw new IllegalStateException("Empty message.")
      case Some(message) =>
        app.connectionSupervisor ! ConnectionSupervisor.Broadcast(ResponseMessage.SystemBroadcast("admin", message))
        val status = s"Message [$message] broadcast successfully."
        Future.successful(Redirect(controllers.admin.activity.routes.ActivityController.activityIndex()).flashing("success" -> status))
    }
  }

  def connectionList = withSession("activity.connection.list", admin = true) { implicit request => implicit td =>
    ask(app.connectionSupervisor, GetSystemStatus)(20.seconds).mapTo[SystemStatus].map { status =>
      Ok(views.html.admin.activity.connectionList(request.identity, status.connections))
    }
  }

  def matchmakingStatus = withSession("activity.matchmaking.status", admin = true) { implicit request => implicit td =>
    Future.successful(Ok(views.html.admin.activity.matchmakingStatus(request.identity, Nil)))
  }

  def gameList = withSession("activity.game.list", admin = true) { implicit request => implicit td =>
    Future.successful(Ok(views.html.admin.activity.gameList(request.identity, Nil)))
  }
}
