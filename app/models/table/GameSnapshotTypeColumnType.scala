/* Generated File */
package models.table

import models.GameSnapshotType
import services.database.SlickQueryService.imports._
import slick.jdbc.JdbcType

object GameSnapshotTypeColumnType {
  implicit val gameSnapshotTypeColumnType: JdbcType[GameSnapshotType] = MappedColumnType.base[GameSnapshotType, String](_.value, GameSnapshotType.withValue)
}
