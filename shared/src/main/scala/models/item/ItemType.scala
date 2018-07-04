package models.item

import enumeratum.values.{StringCirceEnum, StringEnum, StringEnumEntry}

sealed abstract class ItemType(override val value: String) extends StringEnumEntry

object ItemType extends StringEnum[ItemType] with StringCirceEnum[ItemType] {
  case object Armor extends ItemType("armor")
  case object Consumable extends ItemType("consumable")
  case object Detail extends ItemType("detail")
  case object Key extends ItemType("key")
  case object Material extends ItemType("material")
  case object Scroll extends ItemType("scroll")
  case object Weapon extends ItemType("weapon")

  override val values = findValues
}
