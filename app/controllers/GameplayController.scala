package controllers

import java.util.UUID

import akka.actor.{ActorRef, ActorSystem}
import akka.stream.Materializer
import com.mohiva.play.silhouette.api.HandlerResult
import models.auth.Credentials
import models.{Application, RequestMessage, ResponseMessage}
import play.api.mvc.{AnyContent, AnyContentAsEmpty, Request, WebSocket}
import services.ServiceRegistry
import services.player.ConnectionService
import services.supervisor.GameSupervisor
import util.web.{MessageFrameFormatter, WebsocketUtils}

import scala.concurrent.Future

object GameplayController {
  private var gameSupervisorOpt: Option[ActorRef] = None
  def gameSupervisor = gameSupervisorOpt.getOrElse(throw new IllegalStateException(""))
}

@javax.inject.Singleton
class GameplayController @javax.inject.Inject() (
    override val app: Application, implicit val system: ActorSystem, implicit val materializer: Materializer, services: ServiceRegistry
) extends BaseController("home") {

  import app.contexts.webContext

  GameplayController.gameSupervisorOpt = Some(app.actorSystem.actorOf(GameSupervisor.props(app, services), "games"))

  private[this] val formatter = new MessageFrameFormatter()

  def root(debug: Option[Boolean]) = gameplay(path = "", debug = debug)

  def gameplay(path: String, debug: Option[Boolean]) = withSession("gameplay") { implicit request => implicit td =>
    Future.successful(Ok(views.html.gameplay(user = request.identity, path = path, devmode = app.config.debug, debug = debug.getOrElse(app.config.debug))))
  }

  def connect(binary: Boolean) = WebSocket.acceptOrResult[RequestMessage, ResponseMessage] { request =>
    implicit val req: Request[AnyContent] = Request(request, AnyContentAsEmpty)
    val connId = UUID.randomUUID()
    app.silhouette.SecuredRequestHandler { secured => Future.successful(HandlerResult(Ok, Some(secured.identity))) }.map {
      case HandlerResult(_, Some(user)) => Right(WebsocketUtils.actorRef(connId) { out =>
        ConnectionService.props(
          id = Some(connId),
          connSupervisor = app.connSupervisor,
          gameSupervisor = GameplayController.gameSupervisor,
          creds = Credentials(user, request.remoteAddress),
          out = out,
          sourceAddr = request.remoteAddress,
          app = app,
          services = services
        )
      })
      case HandlerResult(_, None) => Left(Redirect(controllers.routes.HomeController.home()).flashing("error" -> "You're not signed in."))
    }
  }(formatter.transformer(binary))
}
