package models.input

import enumeratum._

sealed trait InputCommand extends EnumEntry

object InputCommand extends Enum[InputCommand] {
  case object Testbed extends InputCommand

  case object ActivateMenu extends InputCommand

  case object ToggleDebug extends InputCommand
  case object ToggleGrid extends InputCommand
  case object ToggleBlocks extends InputCommand

  override val values = findValues
}
