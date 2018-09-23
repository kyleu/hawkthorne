/* Generated File */
package controllers.admin.history

import controllers.admin.ServiceController
import java.util.UUID
import models.Application
import models.history.GamePlayerResult
import models.result.orderBy.OrderBy
import play.api.http.MimeTypes
import scala.concurrent.Future
import services.audit.AuditRecordService
import services.history.GamePlayerService
import util.JsonSerializers._
import util.ReftreeUtils._

@javax.inject.Singleton
class GamePlayerController @javax.inject.Inject() (
    override val app: Application, svc: GamePlayerService, auditRecordSvc: AuditRecordService
) extends ServiceController(svc) {
  import app.contexts.webContext

  def createForm = withSession("create.form", admin = true) { implicit request => implicit td =>
    val cancel = controllers.admin.history.routes.GamePlayerController.list()
    val call = controllers.admin.history.routes.GamePlayerController.create()
    Future.successful(Ok(views.html.admin.history.gamePlayerForm(
      request.identity, models.history.GamePlayer.empty(), "New Game Player", cancel, call, isNew = true, debug = app.config.debug
    )))
  }

  def create = withSession("create", admin = true) { implicit request => implicit td =>
    svc.create(request, modelForm(request.body)).map {
      case Some(model) => Redirect(controllers.admin.history.routes.GamePlayerController.view(model.gameId, model.userId))
      case None => Redirect(controllers.admin.history.routes.GamePlayerController.list())
    }
  }

  def list(q: Option[String], orderBy: Option[String], orderAsc: Boolean, limit: Option[Int], offset: Option[Int], t: Option[String] = None) = {
    withSession("list", admin = true) { implicit request => implicit td =>
      val startMs = util.DateUtils.nowMillis
      val orderBys = OrderBy.forVals(orderBy, orderAsc).toSeq
      searchWithCount(q, orderBys, limit, offset).map(r => renderChoice(t) {
        case MimeTypes.HTML => Ok(views.html.admin.history.gamePlayerList(
          request.identity, Some(r._1), r._2, q, orderBy, orderAsc, limit.getOrElse(100), offset.getOrElse(0)
        ))
        case MimeTypes.JSON => Ok(GamePlayerResult.fromRecords(q, Nil, orderBys, limit, offset, startMs, r._1, r._2).asJson)
        case ServiceController.MimeTypes.csv => csvResponse("GamePlayer", svc.csvFor(r._1, r._2))
        case ServiceController.MimeTypes.png => Ok(renderToPng(v = r._2)).as(ServiceController.MimeTypes.png)
        case ServiceController.MimeTypes.svg => Ok(renderToSvg(v = r._2)).as(ServiceController.MimeTypes.svg)
      })
    }
  }

  def autocomplete(q: Option[String], orderBy: Option[String], orderAsc: Boolean, limit: Option[Int]) = {
    withSession("autocomplete", admin = true) { implicit request => implicit td =>
      val orderBys = OrderBy.forVals(orderBy, orderAsc).toSeq
      search(q, orderBys, limit, None).map(r => Ok(r.map(_.toSummary).asJson))
    }
  }

  def byGameId(gameId: UUID, orderBy: Option[String], orderAsc: Boolean, limit: Option[Int], offset: Option[Int], t: Option[String] = None) = {
    withSession("get.by.gameId", admin = true) { implicit request => implicit td =>
      val orderBys = OrderBy.forVals(orderBy, orderAsc).toSeq
      svc.getByGameId(request, gameId, orderBys, limit, offset).map(models => renderChoice(t) {
        case MimeTypes.HTML => Ok(views.html.admin.history.gamePlayerByGameId(
          request.identity, gameId, models, orderBy, orderAsc, limit.getOrElse(5), offset.getOrElse(0)
        ))
        case MimeTypes.JSON => Ok(models.asJson)
        case ServiceController.MimeTypes.csv => csvResponse("GamePlayer by gameId", svc.csvFor(0, models))
        case ServiceController.MimeTypes.png => Ok(renderToPng(v = models)).as(ServiceController.MimeTypes.png)
        case ServiceController.MimeTypes.svg => Ok(renderToSvg(v = models)).as(ServiceController.MimeTypes.svg)
      })
    }
  }

  def byUserId(userId: UUID, orderBy: Option[String], orderAsc: Boolean, limit: Option[Int], offset: Option[Int], t: Option[String] = None) = {
    withSession("get.by.userId", admin = true) { implicit request => implicit td =>
      val orderBys = OrderBy.forVals(orderBy, orderAsc).toSeq
      svc.getByUserId(request, userId, orderBys, limit, offset).map(models => renderChoice(t) {
        case MimeTypes.HTML => Ok(views.html.admin.history.gamePlayerByUserId(
          request.identity, userId, models, orderBy, orderAsc, limit.getOrElse(5), offset.getOrElse(0)
        ))
        case MimeTypes.JSON => Ok(models.asJson)
        case ServiceController.MimeTypes.csv => csvResponse("GamePlayer by userId", svc.csvFor(0, models))
        case ServiceController.MimeTypes.png => Ok(renderToPng(v = models)).as(ServiceController.MimeTypes.png)
        case ServiceController.MimeTypes.svg => Ok(renderToSvg(v = models)).as(ServiceController.MimeTypes.svg)
      })
    }
  }

  def view(gameId: java.util.UUID, userId: java.util.UUID, t: Option[String] = None) = withSession("view", admin = true) { implicit request => implicit td =>
    val modelF = svc.getByPrimaryKey(request, gameId, userId)
    val notesF = app.coreServices.notes.getFor(request, "gamePlayer", gameId, userId)

    notesF.flatMap(notes => modelF.map {
      case Some(model) => renderChoice(t) {
        case MimeTypes.HTML => Ok(views.html.admin.history.gamePlayerView(request.identity, model, notes, app.config.debug))
        case MimeTypes.JSON => Ok(model.asJson)
        case ServiceController.MimeTypes.png => Ok(renderToPng(v = model)).as(ServiceController.MimeTypes.png)
        case ServiceController.MimeTypes.svg => Ok(renderToSvg(v = model)).as(ServiceController.MimeTypes.svg)
      }
      case None => NotFound(s"No GamePlayer found with gameId, userId [$gameId, $userId].")
    })
  }

  def editForm(gameId: java.util.UUID, userId: java.util.UUID) = withSession("edit.form", admin = true) { implicit request => implicit td =>
    val cancel = controllers.admin.history.routes.GamePlayerController.view(gameId, userId)
    val call = controllers.admin.history.routes.GamePlayerController.edit(gameId, userId)
    svc.getByPrimaryKey(request, gameId, userId).map {
      case Some(model) => Ok(
        views.html.admin.history.gamePlayerForm(request.identity, model, s"Game Player [$gameId, $userId]", cancel, call, debug = app.config.debug)
      )
      case None => NotFound(s"No GamePlayer found with gameId, userId [$gameId, $userId].")
    }
  }

  def edit(gameId: java.util.UUID, userId: java.util.UUID) = withSession("edit", admin = true) { implicit request => implicit td =>
    svc.update(request, gameId = gameId, userId = userId, fields = modelForm(request.body)).map(res => render {
      case Accepts.Html() => Redirect(controllers.admin.history.routes.GamePlayerController.view(res._1.gameId, res._1.userId)).flashing("success" -> res._2)
      case Accepts.Json() => Ok(res.asJson)
    })
  }

  def remove(gameId: java.util.UUID, userId: java.util.UUID) = withSession("remove", admin = true) { implicit request => implicit td =>
    svc.remove(request, gameId = gameId, userId = userId).map(_ => render {
      case Accepts.Html() => Redirect(controllers.admin.history.routes.GamePlayerController.list())
      case Accepts.Json() => Ok(io.circe.Json.obj("status" -> io.circe.Json.fromString("removed")))
    })
  }
}
