/* Generated File */
package models.doobie

import models.GameHistoryType
import services.database.DoobieQueryService.Imports._

object GameHistoryTypeDoobie {
  implicit val gameHistoryTypeMeta: Meta[GameHistoryType] = pgEnumStringOpt("GameHistoryType", GameHistoryType.withValueOpt, _.value)
}
