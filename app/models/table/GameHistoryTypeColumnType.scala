/* Generated File */
package models.table

import models.GameHistoryType
import services.database.SlickQueryService.imports._
import slick.jdbc.JdbcType

object GameHistoryTypeColumnType {
  implicit val gameHistoryTypeColumnType: JdbcType[GameHistoryType] = MappedColumnType.base[GameHistoryType, String](_.value, GameHistoryType.withValue)
}
