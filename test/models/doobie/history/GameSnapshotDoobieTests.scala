/* Generated File */
package models.doobie.history

import models.doobie.GameSnapshotTypeDoobie.gameSnapshotTypeMeta
import models.history.GameSnapshot
import org.scalatest._
import services.database.DoobieQueryService.Imports._

class GameSnapshotDoobieTests extends FlatSpec with Matchers {
  import models.doobie.DoobieTestHelper.yolo._

  "Doobie queries for [GameSnapshot]" should "typecheck" in {
    GameSnapshotDoobie.countFragment.query[Long].check.unsafeRunSync
    GameSnapshotDoobie.selectFragment.query[GameSnapshot].check.unsafeRunSync
    (GameSnapshotDoobie.selectFragment ++ whereAnd(GameSnapshotDoobie.searchFragment("..."))).query[GameSnapshot].check.unsafeRunSync
  }
}
