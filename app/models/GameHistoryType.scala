/* Generated File */
package models

import enumeratum.values.{StringCirceEnum, StringEnum, StringEnumEntry}

sealed abstract class GameHistoryType(override val value: String) extends StringEnumEntry

object GameHistoryType extends StringEnum[GameHistoryType] with StringCirceEnum[GameHistoryType] {
  case object Client extends GameHistoryType("client")
  case object Server extends GameHistoryType("server")
  case object Unknown extends GameHistoryType("unknown")

  override val values = findValues
}
