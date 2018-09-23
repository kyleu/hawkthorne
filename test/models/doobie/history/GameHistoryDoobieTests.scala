/* Generated File */
package models.doobie.history

import models.doobie.GameHistoryTypeDoobie.gameHistoryTypeMeta
import models.history.GameHistory
import org.scalatest._
import services.database.DoobieQueryService.Imports._

class GameHistoryDoobieTests extends FlatSpec with Matchers {
  import models.doobie.DoobieTestHelper.yolo._

  "Doobie queries for [GameHistory]" should "typecheck" in {
    GameHistoryDoobie.countFragment.query[Long].check.unsafeRunSync
    GameHistoryDoobie.selectFragment.query[GameHistory].check.unsafeRunSync
    (GameHistoryDoobie.selectFragment ++ whereAnd(GameHistoryDoobie.searchFragment("..."))).query[GameHistory].check.unsafeRunSync
  }
}
