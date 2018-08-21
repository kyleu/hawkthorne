package wiki

import models.data.map.TiledMap
import models.data.series.Episode
import models.player.Costume
import models.template.character.{CharacterListing, CharacterTemplate}
import models.template.enemy.{EnemyListing, EnemyTemplate}
import models.template.inventory.{InventoryListing, InventoryTemplate}
import models.template.npc.{NpcListing, NpcTemplate}
import models.template.projectile.{ProjectileListing, ProjectileTemplate}
import models.template.quest.{QuestListing, QuestTemplate}
import models.template.vehicle.{VehicleListing, VehicleTemplate}
import models.template.weapon.{WeaponListing, WeaponTemplate}
import wiki.content._
import wiki.GameObjectHelper._

object GameObjectFiles {
  private[this] def id(s: String) = {
    s.replaceAllLiterally("'", "").replaceAllLiterally(" ", "").replaceAllLiterally("-", "").replaceAllLiterally("!", "")
  }

  private[this] def characterFiles(cfg: WikiExportConfig) = gameObjectFiles[CharacterTemplate](
    cfg = cfg, key = "Character", plural = "Characters", all = CharacterListing.all,
    k = o => o.key, n = o => id(o.name), i = o => Some(s"characters/${o.key}/base.png"), f = (o, md) => CharacterContent(md, o)
  )

  private[this] def costumeFiles(cfg: WikiExportConfig) = gameObjectFiles[(CharacterTemplate, Costume)](
    cfg = cfg, key = "Costume", plural = "Costumes", all = CharacterListing.all.flatMap(c => c.costumes.map(c -> _)),
    k = o => o._2.key, n = o => id(o._1.name + ExportHelper.toClassName(o._2.key)),
    i = o => Some(s"characters/${o._1.key}/${o._2.key}.png"), f = (o, md) => CostumeContent(md, o)
  )

  private[this] def mapFiles(cfg: WikiExportConfig) = gameObjectFiles[TiledMap](
    cfg = cfg, key = "Map", plural = "Maps", all = TiledMap.values,
    k = o => o.value, n = o => id(o.title), i = o => Some(s"tilesets/${o.value}.png"), f = (o, md) => MapContent(md, o)
  )

  private[this] def enemyFiles(cfg: WikiExportConfig) = gameObjectFiles[EnemyTemplate](
    cfg = cfg, key = "Enemy", plural = "Enemies", all = EnemyListing.all,
    k = o => o.key, n = o => id(o.name), i = o => Some(s"enemies/${o.key}.png"), f = (o, md) => EnemyContent(md, o)
  )

  private[this] def episodeFiles(cfg: WikiExportConfig) = gameObjectFiles[Episode](
    cfg = cfg, key = "Episode", plural = "Episodes", all = Episode.values,
    k = o => o.value, n = o => id(o.value), i = _ => None, f = (o, md) => EpisodeContent(md, o)
  )

  private[this] def inventoryFiles(cfg: WikiExportConfig) = gameObjectFiles[InventoryTemplate](
    cfg = cfg, key = "Inventory", plural = "Inventories", all = InventoryListing.all,
    k = o => o.key, n = o => id(o.name), i = o => Some(s"${o.section}/${o.key}.png"), f = (o, md) => InventoryContent(md, o)
  )

  private[this] def npcFiles(cfg: WikiExportConfig) = gameObjectFiles[NpcTemplate](
    cfg = cfg, key = "NPC", plural = "NPCs", all = NpcListing.all,
    k = o => o.key, n = o => id(o.name), i = o => Some(s"npc/${o.key}.png"), f = (o, md) => NpcContent(md, o)
  )

  private[this] def projectileFiles(cfg: WikiExportConfig) = gameObjectFiles[ProjectileTemplate](
    cfg = cfg, key = "Projectile", plural = "Projectiles", all = ProjectileListing.all,
    k = o => o.key, n = o => id(o.name), i = o => Some(s"weapons/${o.key}.png"), f = (o, md) => ProjectileContent(md, o)
  )

  private[this] def questFiles(cfg: WikiExportConfig) = gameObjectFiles[QuestTemplate](
    cfg = cfg, key = "Quest", plural = "Quests", all = QuestListing.all,
    k = o => o.key, n = o => id(ExportHelper.toClassName(o.key)), i = _ => None, f = (o, md) => QuestContent(md, o)
  )

  private[this] def vehicleFiles(cfg: WikiExportConfig) = gameObjectFiles[VehicleTemplate](
    cfg = cfg, key = "Vehicle", plural = "Vehicles", all = VehicleListing.all,
    k = o => o.key, n = o => id(o.name), i = o => Some(s"vehicles/${o.key}.png"), f = (o, md) => VehicleContent(md, o)
  )

  private[this] def weaponFiles(cfg: WikiExportConfig) = gameObjectFiles[WeaponTemplate](
    cfg = cfg, key = "Weapon", plural = "Weapons", all = WeaponListing.all,
    k = o => o.key, n = o => id(o.name), i = o => Some(s"weapon/${o.key}.png"), f = (o, md) => WeaponContent(md, o)
  )

  def all(cfg: WikiExportConfig): Seq[WikiExportResult.File] = characterFiles(cfg) ++ costumeFiles(cfg) ++
    enemyFiles(cfg) ++ episodeFiles(cfg) ++ inventoryFiles(cfg) ++ mapFiles(cfg) ++ npcFiles(cfg) ++
    projectileFiles(cfg) ++ questFiles(cfg) ++ vehicleFiles(cfg) ++ weaponFiles(cfg)
}
