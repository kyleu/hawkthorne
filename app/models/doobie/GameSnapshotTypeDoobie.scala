/* Generated File */
package models.doobie

import models.GameSnapshotType
import services.database.DoobieQueryService.Imports._

object GameSnapshotTypeDoobie {
  implicit val gameSnapshotTypeMeta: Meta[GameSnapshotType] = pgEnumStringOpt("GameSnapshotType", GameSnapshotType.withValueOpt, _.value)
}
