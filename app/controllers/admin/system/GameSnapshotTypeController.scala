/* Generated File */
package controllers.admin.system

import controllers.BaseController
import controllers.admin.ServiceController
import models.GameSnapshotType
import play.twirl.api.Html
import scala.concurrent.Future
import util.JsonSerializers._

@javax.inject.Singleton
class GameSnapshotTypeController @javax.inject.Inject() (override val app: models.Application) extends BaseController("gameSnapshotType") {
  import app.contexts.webContext

  def list = withSession("list", admin = true) { implicit request => implicit td =>
    Future.successful(render {
      case Accepts.Html() => Ok(views.html.admin.layout.listPage(request.identity, "GameSnapshotType", "explore", GameSnapshotType.values.map(x => Html(x.toString))))
      case Accepts.Json() => Ok(GameSnapshotType.values.asJson)
      case ServiceController.acceptsCsv() => Ok(GameSnapshotType.values.mkString(", ")).as("text/csv")
    })
  }
}
