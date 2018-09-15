/* Generated File */
package models.doobie.analytics

import models.analytics.AnalyticsActionType
import services.database.DoobieQueryService.Imports._

object AnalyticsActionTypeDoobie {
  implicit val analyticsActionTypeMeta: Meta[AnalyticsActionType] = pgEnumStringOpt("AnalyticsActionType", AnalyticsActionType.withValueOpt, _.value)
}
