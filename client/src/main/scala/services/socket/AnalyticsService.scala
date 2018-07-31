package services.socket

import models.RequestMessage.AnalyticsMessage
import models.analytics.AnalyticsActionType

object AnalyticsService {
  def send(t: AnalyticsActionType, arg: String) = {
    NetworkMessage.sendMessage(AnalyticsMessage(t = t, arg = arg))
  }
}
