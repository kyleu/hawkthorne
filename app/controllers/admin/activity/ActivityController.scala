package controllers.admin.activity

import java.util.UUID

import controllers.BaseController
import models.{Application, ResponseMessage}
import models.InternalMessage._

import scala.concurrent.Future
import akka.pattern.ask
import services.game.GameInstanceDebug
import services.supervisor.ConnectionSupervisor
import util.JsonSerializers._

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
        app.connSupervisor ! ConnectionSupervisor.Broadcast(ResponseMessage.SystemBroadcast("admin", message))
        val status = s"Message [$message] broadcast successfully."
        Future.successful(Redirect(controllers.admin.activity.routes.ActivityController.activityIndex()).flashing("success" -> status))
    }
  }

  def connectionList = withSession("activity.connection.list", admin = true) { implicit request => implicit td =>
    ask(app.connSupervisor, GetSystemStatus)(20.seconds).mapTo[ConnectionStatus].map { status =>
      Ok(views.html.admin.activity.connectionList(request.identity, status.connections))
    }
  }

  def connectionDetail(id: UUID) = withSession("activity.connection.detail", admin = true) { implicit request => implicit td =>
    ask(app.gameSupervisor, SendConnectionTrace(id))(20.seconds).mapTo[String].map { c =>
      Ok(views.html.admin.activity.connectionDetail(request.identity, id, c.asJson))
    }
  }

  def gameList = withSession("activity.game.list", admin = true) { implicit request => implicit td =>
    ask(app.gameSupervisor, GetSystemStatus)(20.seconds).mapTo[GameStatus].map { status =>
      Ok(views.html.admin.activity.gameList(request.identity, status.games))
    }
  }

  def gameDetail(id: UUID) = withSession("activity.game.detail", admin = true) { implicit request => implicit td =>
    ask(app.gameSupervisor, SendGameTrace(id))(20.seconds).mapTo[GameInstanceDebug].map { gid =>
      Ok(views.html.admin.activity.gameDetail(request.identity, gid))
    }
  }
}
