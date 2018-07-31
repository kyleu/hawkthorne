package services.analytics

import io.circe.Json
import models.analytics.{AnalyticsAction, AnalyticsActionType}
import models.auth.Credentials
import util.Logging
import util.tracing.{TraceData, TracingService}

@javax.inject.Singleton
class AnalyticsService @javax.inject.Inject() (tracing: TracingService, actionSvc: AnalyticsActionService) extends Logging {
  def onMessage(t: AnalyticsActionType, arg: Json, credentials: Credentials, status: String) = {
    val act = AnalyticsAction.empty(t = t, arg = arg, author = credentials.user.id, status = status)
    log.info(s"Analytics event [${act.t}] received for user [${act.author}] with status [${act.status}].")
    actionSvc.insert(credentials, act)(new TraceData)
  }
}
