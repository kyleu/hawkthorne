package pipeline

import better.files.File
import pipeline.file.ScalaFile
import util.LuaUtils

import scala.io.Source

object InventoryItemFiles {
  case class Item(key: String, description: String, dir: String, info: String, maxItems: Int)

  def process(cfg: PipelineConfig) = {
    val sections = Seq("armor", "consumables", "details", "keys", "materials", "misc", "weapons")
    sections.flatMap(parseSection(cfg, _))
  }

  private[this] def strip(s: String) = {
    s.trim.stripPrefix("'").stripPrefix("\"").stripSuffix(",").stripSuffix("'").stripSuffix("\"").trim.replaceAllLiterally("\\'", "'")
  }

  private[this] def cleanSectionKey(sectionKey: String) = sectionKey match {
    case "armor" => "armors"
    case x => x
  }

  private[this] def getItem(sectionKey: String, file: File) = {
    val lines = Source.fromString(file.contentAsString).getLines.map(_.trim).toIndexedSeq
    val key = strip(LuaUtils.lineFor(file.name, lines, "name ="))
    val description = strip(LuaUtils.lineOpt(lines, "description =").getOrElse(key))
    val dir = cleanSectionKey(strip(LuaUtils.lineOpt(lines, "directory =").getOrElse(sectionKey)).stripSuffix("/").trim)
    val info = strip(LuaUtils.lineOpt(lines, "info =").getOrElse("TODO")).replaceAllLiterally("\"", "\\\"")
    val maxItems = strip(LuaUtils.lineOpt(lines, "MAX_ITEMS =").getOrElse("1")).toInt

    if (sectionKey == "details" && key != "quest") {
      None
    } else {
      Some(Item(key = key, description = description, dir = dir, info = info, maxItems = maxItems))
    }
  }

  private[this] def parseSection(cfg: PipelineConfig, sectionKey: String) = {
    val name = ExportHelper.toClassName(sectionKey)

    val pkg = Seq("models", "data", "inventory")
    val file = ScalaFile(pkg = pkg, key = name + "Inventory", root = Some("shared/src/main/scala"))

    file.addImport("models.template.inventory", "InventoryTemplate")

    file.add(s"object ${name}Inventory {", 1)

    val children = (cfg.src / "items" / sectionKey).children.filter(LuaUtils.qualifies).toSeq
    val items = children.flatMap(getItem(sectionKey, _))
    items.foreach { item =>
      file.add(s"val ${item.key} = InventoryTemplate(", 1)
      file.add(s"""key = "${item.key}",""")
      file.add(s"""name = "${item.description}",""")
      file.add(s"""section = "${item.dir}",""")
      file.add(s"""info = "${item.info}",""")
      file.add(s"""maxItems = ${item.maxItems}""")
      file.add(")", -1)
      file.add()
    }

    file.add(s"""val all = Seq(${items.map(_.key).mkString(", ")})""")
    file.add("}", -1)

    cfg.writeScalaResult(s"inventory/$sectionKey", file.path -> file.rendered)
  }
}
