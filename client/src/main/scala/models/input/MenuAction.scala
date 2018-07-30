package models.input

import enumeratum.values.{StringCirceEnum, StringEnum, StringEnumEntry}

sealed abstract class MenuAction(override val value: String) extends StringEnumEntry

object MenuAction extends StringEnum[MenuAction] with StringCirceEnum[MenuAction] {
  case object Up extends MenuAction("up")
  case object Right extends MenuAction("right")
  case object Down extends MenuAction("down")
  case object Left extends MenuAction("left")

  case object Select extends MenuAction("select")
  case object Back extends MenuAction("back")

  override val values = findValues
}
