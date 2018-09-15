/* Generated File */
package models.doobie.trace

import models.doobie.DoobieTestHelper
import models.doobie.TraceTypeEnumDoobie.traceTypeEnumMeta
import models.trace.TraceResult
import org.scalatest._
import services.database.DoobieQueryService.Imports._

class TraceResultDoobieTest extends FlatSpec with Matchers {
  import DoobieTestHelper.yolo._

  "Doobie queries for [TraceResult]" should "typecheck" in {
    TraceResultDoobie.countFragment.query[Long].check.unsafeRunSync
    TraceResultDoobie.selectFragment.query[TraceResult].check.unsafeRunSync
    (TraceResultDoobie.selectFragment ++ whereAnd(TraceResultDoobie.searchFragment("..."))).query[TraceResult].check.unsafeRunSync
  }
}
