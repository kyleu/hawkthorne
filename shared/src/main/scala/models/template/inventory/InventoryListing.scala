package models.template.inventory

import models.data.inventory._

object InventoryListing {
  val all = Seq(
    ArmorInventory.all,
    ConsumablesInventory.all,
    DetailsInventory.all,
    KeysInventory.all,
    MaterialsInventory.all,
    MiscInventory.all,
    WeaponsInventory.all
  ).flatten.sortBy(_.key)
}
