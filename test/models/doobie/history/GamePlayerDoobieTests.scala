/* Generated File */
package models.doobie.history

import models.history.GamePlayer
import org.scalatest._
import services.database.DoobieQueryService.Imports._

class GamePlayerDoobieTests extends FlatSpec with Matchers {
  import models.doobie.DoobieTestHelper.yolo._

  "Doobie queries for [GamePlayer]" should "typecheck" in {
    GamePlayerDoobie.countFragment.query[Long].check.unsafeRunSync
    GamePlayerDoobie.selectFragment.query[GamePlayer].check.unsafeRunSync
    (GamePlayerDoobie.selectFragment ++ whereAnd(GamePlayerDoobie.searchFragment("..."))).query[GamePlayer].check.unsafeRunSync
  }
}
