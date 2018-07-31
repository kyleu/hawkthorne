package services.socket

import io.circe.Json
import models.RequestMessage.AnalyticsMessage
import models.analytics.AnalyticsActionType

object AnalyticsService {
  def send(t: AnalyticsActionType, arg: Json) = {
    NetworkMessage.sendMessage(AnalyticsMessage(t = t, arg = arg))
  }
}
