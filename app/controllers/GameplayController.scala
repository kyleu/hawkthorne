package controllers

import java.util.UUID

import akka.actor.ActorSystem
import akka.stream.Materializer
import com.mohiva.play.silhouette.api.HandlerResult
import io.circe.Json
import models.analytics.AnalyticsAction
import models.auth.Credentials
import models.{Application, RequestMessage, ResponseMessage}
import play.api.mvc.{AnyContent, AnyContentAsEmpty, Request, WebSocket}
import services.analytics.AnalyticsActionService
import services.player.PlayerSocketService
import util.JsonSerializers._
import util.tracing.TraceData
import util.web.{MessageFrameFormatter, WebsocketUtils}

import scala.concurrent.Future

@javax.inject.Singleton
class GameplayController @javax.inject.Inject() (
    override val app: Application, implicit val system: ActorSystem, implicit val materializer: Materializer, analyticsSvc: AnalyticsActionService
) extends BaseController("home") {

  import app.contexts.webContext

  private[this] val formatter = new MessageFrameFormatter()

  def root(debug: Boolean) = gameplay(path = "", debug = debug)

  def gameplay(path: String, debug: Boolean) = withSession("gameplay") { implicit request => implicit td =>
    Future.successful(Ok(views.html.gameplay(user = request.identity, path = path, devmode = app.config.debug, debug = debug)))
  }

  private[this] def callbacksFor(userId: UUID) = PlayerSocketService.Callbacks(analytics = (t, arg) => {
    val act = AnalyticsAction.empty(t = t, arg = arg, author = userId, status = "OK")
    log.info(s"Analytics event [${act.t}] received for user [${act.author}] with status [${act.status}].")
    analyticsSvc.insert(Credentials.system, act)(new TraceData)
  })

  def connect(binary: Boolean) = WebSocket.acceptOrResult[RequestMessage, ResponseMessage] { request =>
    implicit val req: Request[AnyContent] = Request(request, AnyContentAsEmpty)
    val connId = UUID.randomUUID()
    app.silhouette.SecuredRequestHandler { secured => Future.successful(HandlerResult(Ok, Some(secured.identity))) }.map {
      case HandlerResult(_, Some(user)) => Right(WebsocketUtils.actorRef(connId) { out =>
        PlayerSocketService.props(
          id = Some(connId),
          playerSupervisor = app.playerSupervisor,
          creds = Credentials(user, request.remoteAddress),
          out = out,
          sourceAddr = request.remoteAddress,
          callbacks = callbacksFor(user.id)
        )
      })
      case HandlerResult(_, None) => Left(Redirect(controllers.routes.HomeController.home()).flashing("error" -> "You're not signed in."))
    }
  }(formatter.transformer(binary))
}
