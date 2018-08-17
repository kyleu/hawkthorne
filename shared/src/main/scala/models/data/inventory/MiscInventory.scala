/* Generated File */
package models.data.inventory

import models.template.inventory.InventoryTemplate

object MiscInventory {
  val lightning = InventoryTemplate(
    key = "lightning",
    name = "Lightning",
    section = "scrolls",
    info = "An ancient spell used to strike down enemies",
    maxItems = 5
  )

  val ghost_pepper = InventoryTemplate(
    key = "ghost_pepper",
    name = "Ghostly Summons",
    section = "scrolls",
    info = "Summons the ghost of peppers past",
    maxItems = 5
  )

  val all = Seq(lightning, ghost_pepper)
}
