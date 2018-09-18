package controllers.admin.activity

import java.util.UUID

import controllers.{BaseController, GameplayController}
import models.{Application, ResponseMessage}
import models.InternalMessage._

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
    ask(app.connSupervisor, ConnectionTraceRequest(id))(20.seconds).mapTo[ConnectionTraceResponse].map { c =>
      Ok(views.html.admin.activity.connectionDetail(request.identity, c))
    }
  }

  def clientDetail(id: UUID) = withSession("activity.client.detail", admin = true) { implicit request => implicit td =>
    ask(app.connSupervisor, ClientTraceRequest(id))(20.seconds).mapTo[ClientTraceResponse].map { c =>
      Ok(views.html.admin.activity.clientDetail(request.identity, c))
    }
  }

  def gameList = withSession("activity.game.list", admin = true) { implicit request => implicit td =>
    ask(GameplayController.gameSupervisor, GetSystemStatus)(20.seconds).mapTo[GameStatus].map { status =>
      Ok(views.html.admin.activity.gameList(request.identity, status.games))
    }
  }

  def gameDetail(id: UUID) = withSession("activity.game.detail", admin = true) { implicit request => implicit td =>
    ask(GameplayController.gameSupervisor, GameTraceRequest(id))(20.seconds).mapTo[GameTraceResponse].map { gtr =>
      Ok(views.html.admin.activity.gameDetail(request.identity, gtr.game))
    }
  }
}
