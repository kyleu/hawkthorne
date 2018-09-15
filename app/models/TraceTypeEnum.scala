/* Generated File */
package models

import enumeratum.values.{StringCirceEnum, StringEnum, StringEnumEntry}

sealed abstract class TraceTypeEnum(override val value: String) extends StringEnumEntry

object TraceTypeEnum extends StringEnum[TraceTypeEnum] with StringCirceEnum[TraceTypeEnum] {
  case object Client extends TraceTypeEnum("client")
  case object Connection extends TraceTypeEnum("connection")
  case object Game extends TraceTypeEnum("game")
  case object Unknown extends TraceTypeEnum("unknown")

  override val values = findValues
}
