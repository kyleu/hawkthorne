package pipeline

import pipeline.file.ScalaFile
import util.LuaUtils

import scala.io.Source

object NpcFiles {
  def process(cfg: PipelineConfig) = {
    (cfg.src / "npcs").children.filter(LuaUtils.qualifies).toSeq.flatMap { src =>
      val lines = Source.fromString(src.contentAsString).getLines.map(_.trim).toIndexedSeq

      val key = src.name.stripSuffix(".lua")
      val name = nameFor(key)

      val width = LuaUtils.lineFor(src.name, lines, "width = ").toInt
      val height = LuaUtils.lineFor(src.name, lines, "height = ").toInt

      val greeting = LuaUtils.lineOpt(lines, "greeting = ").map(LuaUtils.clean)
      val noInventory = LuaUtils.lineOpt(lines, "noinventory = ").map(LuaUtils.clean)
      val noCommands = LuaUtils.lineOpt(lines, "nocommands = ").map(LuaUtils.clean)

      val pkg = Seq("models", "data", "npc")
      val file = ScalaFile(pkg = pkg, key = name, root = Some("shared/src/main/scala"))

      file.addImport("models.npc", "NpcTemplate")

      file.add(s"object $name extends NpcTemplate(", 1)
      file.add(s"""key = "$key",""")
      file.add(s"""name = "$name",""")
      file.add(s"""width = $width,""")
      file.add(s"""height = $height,""")
      file.add(s"""greeting = ${greeting.map("Some(\"" + _ + "\")").getOrElse("None")},""")
      file.add(s"""noInventory = ${noInventory.map("Some(\"" + _ + "\")").getOrElse("None")},""")
      file.add(s"""noCommands = ${noCommands.map("Some(\"" + _ + "\")").getOrElse("None")},""")
      file.add(s"""animations = Seq.empty""")
      file.add(")", -1)

      cfg.writeScalaResult(s"npcs/${src.name}", file.path -> file.rendered)
    }
  }

  private[this] def nameFor(key: String) = key match {
    case "anniesboobs" => "AnniesBoobs"
    case "babyabed" => "BabyAbed"
    case "blacksmithjuan" => "BlacksmithJuan"
    case "gaynpc" => "GayNpc"
    case "humanbeing" => "HumanBeing"
    case "juan1" => "Juan"
    case "jumpinggirl" => "JumpingGirl"
    case "laserlotus1" => "LaserLotus1"
    case "laserlotus2" => "LaserLotus2"
    case "mayorjuan" => "MayorJuan"
    case "notstarburns" => "NotStarburns"
    case "oldman" => "OldMan"
    case "profholly" => "ProfHolly"
    case "senorjuan" => "SenorJuan"
    case "sophieb" => "SophieB"
    case "telescopejuan" => "TelescopeJuan"
    case "townknight" => "TownKnight"
    case "townlady" => "TownLady"
    case "xmaswizard" => "XmasWizard"
    case _ => ExportHelper.toClassName(key)
  }
}
