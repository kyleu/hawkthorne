package wiki

import models.data.inventory._
import models.template.inventory.InventoryTemplate
import wiki.GameObjectHelper._
import wiki.content._

object GameObjectInventoryFiles {
  private[this] def id(s: String) = {
    s.replaceAllLiterally("'", "").replaceAllLiterally(" ", "").replaceAllLiterally("-", "").replaceAllLiterally("!", "")
  }

  private[this] def inventoryArmorFiles(cfg: WikiExportConfig) = gameObjectFiles[InventoryTemplate](GameObjectHelper.Params(
    cfg = cfg, key = "InventoryArmor", plural = "Inventory Armor", dirOverride = Some("inventory/armor"), all = ArmorInventory.all,
    k = o => o.key, n = o => id(o.name) -> o.name, i = o => Some(s"${o.section}/${o.key}.png"), f = (o, md) => InventoryContent(md, o)
  ))

  private[this] def inventoryConsumableFiles(cfg: WikiExportConfig) = gameObjectFiles[InventoryTemplate](GameObjectHelper.Params(
    cfg = cfg, key = "InventoryConsumable", plural = "Inventory Consumable", dirOverride = Some("inventory/consumable"), all = ConsumablesInventory.all,
    k = o => o.key, n = o => id(o.name) -> o.name, i = o => Some(s"${o.section}/${o.key}.png"), f = (o, md) => InventoryContent(md, o)
  ))

  private[this] def inventoryDetailFiles(cfg: WikiExportConfig) = gameObjectFiles[InventoryTemplate](GameObjectHelper.Params(
    cfg = cfg, key = "InventoryDetail", plural = "Inventory Detail", dirOverride = Some("inventory/detail"), all = DetailsInventory.all,
    k = o => o.key, n = o => id(o.name) -> o.name, i = o => Some(s"${o.section}/${o.key}.png"), f = (o, md) => InventoryContent(md, o)
  ))

  private[this] def inventoryKeyFiles(cfg: WikiExportConfig) = gameObjectFiles[InventoryTemplate](GameObjectHelper.Params(
    cfg = cfg, key = "InventoryKey", plural = "Inventory Key", dirOverride = Some("inventory/key"), all = KeysInventory.all,
    k = o => o.key, n = o => id(o.name) -> o.name, i = o => Some(s"${o.section}/${o.key}.png"), f = (o, md) => InventoryContent(md, o)
  ))

  private[this] def inventoryMaterialFiles(cfg: WikiExportConfig) = gameObjectFiles[InventoryTemplate](GameObjectHelper.Params(
    cfg = cfg, key = "InventoryMaterial", plural = "Inventory Material", dirOverride = Some("inventory/material"), all = MaterialsInventory.all,
    k = o => o.key, n = o => id(o.name) -> o.name, i = o => Some(s"${o.section}/${o.key}.png"), f = (o, md) => InventoryContent(md, o)
  ))

  private[this] def inventoryMiscFiles(cfg: WikiExportConfig) = gameObjectFiles[InventoryTemplate](GameObjectHelper.Params(
    cfg = cfg, key = "InventoryMisc", plural = "Inventory Misc", dirOverride = Some("inventory/misc"), all = MiscInventory.all,
    k = o => o.key, n = o => id(o.name) -> o.name, i = o => Some(s"${o.section}/${o.key}.png"), f = (o, md) => InventoryContent(md, o)
  ))

  private[this] def inventoryWeaponFiles(cfg: WikiExportConfig) = gameObjectFiles[InventoryTemplate](GameObjectHelper.Params(
    cfg = cfg, key = "InventoryWeapon", plural = "Inventory Weapon", dirOverride = Some("inventory/weapon"), all = WeaponsInventory.all,
    k = o => o.key, n = o => id(o.name) -> o.name, i = o => Some(s"${o.section}/${o.key}.png"), f = (o, md) => InventoryContent(md, o)
  ))

  def all(cfg: WikiExportConfig): Seq[WikiExportResult.File] = inventoryArmorFiles(cfg) ++ inventoryConsumableFiles(cfg) ++ inventoryDetailFiles(cfg) ++
    inventoryKeyFiles(cfg) ++ inventoryMaterialFiles(cfg) ++ inventoryMiscFiles(cfg) ++ inventoryWeaponFiles(cfg)
}
