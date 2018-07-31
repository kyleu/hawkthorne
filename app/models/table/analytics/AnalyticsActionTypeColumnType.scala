/* Generated File */
package models.table.analytics

import models.analytics.AnalyticsActionType
import services.database.SlickQueryService.imports._
import slick.jdbc.JdbcType

object AnalyticsActionTypeColumnType {
  implicit val analyticsActionTypeColumnType: JdbcType[AnalyticsActionType] = MappedColumnType.base[AnalyticsActionType, String](_.value, AnalyticsActionType.withValue)
}
