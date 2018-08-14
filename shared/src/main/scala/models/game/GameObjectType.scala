package models.game

import enumeratum.values.{StringCirceEnum, StringEnum, StringEnumEntry}

sealed abstract class GameObjectType(
    override val value: String, val logic: String
) extends StringEnumEntry

object GameObjectType extends StringEnum[GameObjectType] with StringCirceEnum[GameObjectType] {
  case object Sprite extends GameObjectType(value = "sprite", logic = "TODO")
  case object WorkInProgress extends GameObjectType(value = "wip", logic = "TODO")

  override val values = findValues
}
