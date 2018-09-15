/* Generated File */
package models.doobie.analytics

import models.analytics.AnalyticsAction
import models.doobie.DoobieTestHelper
import models.doobie.analytics.AnalyticsActionTypeDoobie.analyticsActionTypeMeta
import org.scalatest._
import services.database.DoobieQueryService.Imports._

class AnalyticsActionDoobieTest extends FlatSpec with Matchers {
  import DoobieTestHelper.yolo._

  "Doobie queries for [AnalyticsAction]" should "typecheck" in {
    AnalyticsActionDoobie.countFragment.query[Long].check.unsafeRunSync
    AnalyticsActionDoobie.selectFragment.query[AnalyticsAction].check.unsafeRunSync
    (AnalyticsActionDoobie.selectFragment ++ whereAnd(AnalyticsActionDoobie.searchFragment("..."))).query[AnalyticsAction].check.unsafeRunSync
  }
}
