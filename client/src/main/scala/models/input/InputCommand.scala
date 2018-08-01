package models.input

import enumeratum.values.{StringCirceEnum, StringEnum, StringEnumEntry}

sealed abstract class InputCommand(override val value: String) extends StringEnumEntry

object InputCommand extends StringEnum[InputCommand] with StringCirceEnum[InputCommand] {
  case object Jump extends InputCommand("jump")
  case object Attack extends InputCommand("attack")

  case object Select extends InputCommand("select")
  case object Confirm extends InputCommand("confirm")

  case object Options extends InputCommand("options")
  case object Debug extends InputCommand("debug")

  override val values = findValues
}
