/* Generated File */
package controllers.admin.analytics

import controllers.BaseController
import controllers.admin.ServiceController
import models.analytics.AnalyticsActionType
import play.twirl.api.Html
import scala.concurrent.Future
import util.JsonSerializers._

@javax.inject.Singleton
class AnalyticsActionTypeController @javax.inject.Inject() (override val app: models.Application) extends BaseController("analyticsActionType") {
  import app.contexts.webContext

  def list = withSession("list", admin = true) { implicit request => implicit td =>
    Future.successful(render {
      case Accepts.Html() => Ok(views.html.admin.layout.listPage(request.identity, "AnalyticsActionType", "explore", AnalyticsActionType.values.map(x => Html(x.toString))))
      case Accepts.Json() => Ok(AnalyticsActionType.values.asJson)
      case ServiceController.acceptsCsv() => Ok(AnalyticsActionType.values.mkString(", ")).as("text/csv")
    })
  }
}
