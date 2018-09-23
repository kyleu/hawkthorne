/* Generated File */
package models

import enumeratum.values.{StringCirceEnum, StringEnum, StringEnumEntry}

sealed abstract class GameSnapshotType(override val value: String) extends StringEnumEntry

object GameSnapshotType extends StringEnum[GameSnapshotType] with StringCirceEnum[GameSnapshotType] {
  case object Initial extends GameSnapshotType("initial")
  case object Manual extends GameSnapshotType("manual")
  case object Final extends GameSnapshotType("final")
  case object Unknown extends GameSnapshotType("unknown")

  override val values = findValues
}
