package controllers

import java.util.UUID

import akka.actor.ActorSystem
import akka.stream.Materializer
import com.mohiva.play.silhouette.api.HandlerResult
import models.auth.Credentials
import models.{Application, RequestMessage, ResponseMessage}
import play.api.mvc.{AnyContent, AnyContentAsEmpty, Request, WebSocket}
import services.analytics.AnalyticsService
import services.player.PlayerConnectionService
import util.web.{MessageFrameFormatter, WebsocketUtils}

import scala.concurrent.Future

@javax.inject.Singleton
class GameplayController @javax.inject.Inject() (
    override val app: Application, implicit val system: ActorSystem, implicit val materializer: Materializer, analyticsSvc: AnalyticsService
) extends BaseController("home") {

  import app.contexts.webContext

  private[this] val formatter = new MessageFrameFormatter()

  def root(debug: Option[Boolean]) = gameplay(path = "", debug = debug)

  def gameplay(path: String, debug: Option[Boolean]) = withSession("gameplay") { implicit request => implicit td =>
    Future.successful(Ok(views.html.gameplay(user = request.identity, path = path, devmode = app.config.debug, debug = debug.getOrElse(app.config.debug))))
  }

  private[this] def callbacksFor(credentials: Credentials, status: String = "OK") = PlayerConnectionService.Callbacks(analytics = (t, arg) => {
    analyticsSvc.onMessage(t = t, arg = arg, credentials, status = status)
  })

  def connect(binary: Boolean) = WebSocket.acceptOrResult[RequestMessage, ResponseMessage] { request =>
    implicit val req: Request[AnyContent] = Request(request, AnyContentAsEmpty)
    val connId = UUID.randomUUID()
    app.silhouette.SecuredRequestHandler { secured => Future.successful(HandlerResult(Ok, Some(secured.identity))) }.map {
      case HandlerResult(_, Some(user)) => Right(WebsocketUtils.actorRef(connId) { out =>
        PlayerConnectionService.props(
          id = Some(connId),
          playerSupervisor = app.connectionSupervisor,
          creds = Credentials(user, request.remoteAddress),
          out = out,
          sourceAddr = request.remoteAddress,
          callbacks = callbacksFor(Credentials(user = user, remoteAddress = request.remoteAddress))
        )
      })
      case HandlerResult(_, None) => Left(Redirect(controllers.routes.HomeController.home()).flashing("error" -> "You're not signed in."))
    }
  }(formatter.transformer(binary))
}
