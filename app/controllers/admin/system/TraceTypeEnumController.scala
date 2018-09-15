/* Generated File */
package controllers.admin.system

import controllers.BaseController
import controllers.admin.ServiceController
import models.TraceTypeEnum
import play.twirl.api.Html
import scala.concurrent.Future
import util.JsonSerializers._

@javax.inject.Singleton
class TraceTypeEnumController @javax.inject.Inject() (override val app: models.Application) extends BaseController("traceTypeEnum") {
  import app.contexts.webContext

  def list = withSession("list", admin = true) { implicit request => implicit td =>
    Future.successful(render {
      case Accepts.Html() => Ok(views.html.admin.layout.listPage(request.identity, "TraceTypeEnum", "explore", TraceTypeEnum.values.map(x => Html(x.toString))))
      case Accepts.Json() => Ok(TraceTypeEnum.values.asJson)
      case ServiceController.acceptsCsv() => Ok(TraceTypeEnum.values.mkString(", ")).as("text/csv")
    })
  }
}
