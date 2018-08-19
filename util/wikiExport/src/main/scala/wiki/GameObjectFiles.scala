package wiki

import models.data.map.TiledMap
import models.template.character.{CharacterListing, CharacterTemplate}
import models.template.enemy.{EnemyListing, EnemyTemplate}
import models.template.inventory.{InventoryListing, InventoryTemplate}
import models.template.npc.{NpcListing, NpcTemplate}
import models.template.projectile.{ProjectileListing, ProjectileTemplate}
import models.template.quest.{QuestListing, QuestTemplate}
import models.template.vehicle.{VehicleListing, VehicleTemplate}
import models.template.weapon.{WeaponListing, WeaponTemplate}

object GameObjectFiles {
  def listingFile(cfg: WikiExportConfig, key: String, plural: String, names: Seq[String]) = {
    val title = s"${key}_Listing"
    val md = new MarkdownFile(dir = key.toLowerCase, title = title)
    md.add(s"Here are all of the ${plural.toLowerCase} in ${util.Version.projectName}.")
    names.foreach { name =>
      md.add(s"* [$name]($key${name.replaceAllLiterally(" ", "_")})")
    }
    cfg.writeMarkdownResult(title, md.path -> md.rendered).toSeq
  }

  private[this] def gameObjectFiles[T](
    cfg: WikiExportConfig, key: String, plural: String, all: Seq[T],
    k: T => String, n: T => String, i: T => String, f: (T, MarkdownFile) => Unit
  ) = listingFile(cfg, key, plural, all.map(n)) ++ all.flatMap { o =>
    val md = new MarkdownFile(dir = key.toLowerCase, title = key + n(o))
    md.addHeader(n(o))
    md.add(MarkdownUtils.img(i(o), s"${k(o)} ${n(o)} texture"))
    f(o, md)
    cfg.writeMarkdownResult(k(o), md.path -> md.rendered)
  }

  private[this] def id(s: String) = {
    s.replaceAllLiterally("'", "").replaceAllLiterally(" ", "").replaceAllLiterally("-", "").replaceAllLiterally("!", "")
  }
  def todo[T](md: MarkdownFile, o: T) = {
    md.add()
    md.add("TODO")
  }

  private[this] def characterFiles(cfg: WikiExportConfig) = gameObjectFiles[CharacterTemplate](
    cfg = cfg, key = "Character", plural = "Characters", all = CharacterListing.all,
    k = o => o.key, n = o => id(o.name), i = o => s"characters/${o.key}/base.png", f = (o, md) => todo(md, o)
  )

  private[this] def mapFiles(cfg: WikiExportConfig) = gameObjectFiles[TiledMap](
    cfg = cfg, key = "Map", plural = "Maps", all = TiledMap.values,
    k = o => o.value, n = o => id(o.title), i = o => s"tilesets/${o.value}.png", f = (o, md) => todo(md, o)
  )

  private[this] def enemyFiles(cfg: WikiExportConfig) = gameObjectFiles[EnemyTemplate](
    cfg = cfg, key = "Enemy", plural = "Enemies", all = EnemyListing.all,
    k = o => o.key, n = o => id(o.name), i = o => s"enemies/${o.key}.png", f = (o, md) => todo(md, o)
  )

  private[this] def npcFiles(cfg: WikiExportConfig) = gameObjectFiles[NpcTemplate](
    cfg = cfg, key = "NPC", plural = "NPCs", all = NpcListing.all,
    k = o => o.key, n = o => id(o.name), i = o => s"npc/${o.key}.png", f = (o, md) => todo(md, o)
  )

  private[this] def projectileFiles(cfg: WikiExportConfig) = gameObjectFiles[ProjectileTemplate](
    cfg = cfg, key = "Projectile", plural = "Projectiles", all = ProjectileListing.all,
    k = o => o.key, n = o => id(o.name), i = o => s"weapons/${o.key}.png", f = (o, md) => todo(md, o)
  )

  private[this] def questFiles(cfg: WikiExportConfig) = gameObjectFiles[QuestTemplate](
    cfg = cfg, key = "Quest", plural = "Quests", all = QuestListing.all,
    k = o => o.key, n = o => id(o.name), i = o => s"enemies/${o.key}.png", f = (o, md) => todo(md, o)
  )

  private[this] def vehicleFiles(cfg: WikiExportConfig) = gameObjectFiles[VehicleTemplate](
    cfg = cfg, key = "Vehicle", plural = "Vehicles", all = VehicleListing.all,
    k = o => o.key, n = o => id(o.name), i = o => s"enemies/${o.key}.png", f = (o, md) => todo(md, o)
  )

  private[this] def weaponFiles(cfg: WikiExportConfig) = gameObjectFiles[WeaponTemplate](
    cfg = cfg, key = "Weapon", plural = "Weapons", all = WeaponListing.all,
    k = o => o.key, n = o => id(o.name), i = o => s"weapon/${o.key}.png", f = (o, md) => todo(md, o)
  )

  private[this] def inventoryFiles(cfg: WikiExportConfig) = gameObjectFiles[InventoryTemplate](
    cfg = cfg, key = "Inventory", plural = "Inventories", all = InventoryListing.all,
    k = o => o.key, n = o => id(o.name), i = o => s"weapon/${o.key}.png", f = (o, md) => todo(md, o)
  )

  def all(cfg: WikiExportConfig): Seq[WikiExportResult.File] = {
    characterFiles(cfg) ++ mapFiles(cfg) ++ inventoryFiles(cfg) ++
      enemyFiles(cfg) ++ npcFiles(cfg) ++ projectileFiles(cfg) ++ questFiles(cfg) ++ vehicleFiles(cfg) ++ weaponFiles(cfg)
  }
}
