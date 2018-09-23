/* Generated File */
package controllers.admin.system

import controllers.BaseController
import controllers.admin.ServiceController
import models.GameHistoryType
import play.twirl.api.Html
import scala.concurrent.Future
import util.JsonSerializers._

@javax.inject.Singleton
class GameHistoryTypeController @javax.inject.Inject() (override val app: models.Application) extends BaseController("gameHistoryType") {
  import app.contexts.webContext

  def list = withSession("list", admin = true) { implicit request => implicit td =>
    Future.successful(render {
      case Accepts.Html() => Ok(views.html.admin.layout.listPage(request.identity, "GameHistoryType", "explore", GameHistoryType.values.map(x => Html(x.toString))))
      case Accepts.Json() => Ok(GameHistoryType.values.asJson)
      case ServiceController.acceptsCsv() => Ok(GameHistoryType.values.mkString(", ")).as("text/csv")
    })
  }
}
