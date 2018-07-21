package pipeline

import better.files.File
import pipeline.file.ScalaFile

import scala.io.Source

object NpcFiles {

  private[this] def qualifies(f: File) = f.name.endsWith(".lua") && (f.name != "init.lua")

  private[this] def clean(s: String) = s.stripPrefix("'").stripPrefix("\"").stripSuffix(",").stripSuffix("'").stripSuffix("\"").replaceAllLiterally("\"", "\\\"")

  def process(cfg: PipelineConfig) = {
    (cfg.src / "npcs").children.filter(qualifies).toSeq.flatMap { src =>
      val lines = Source.fromString(src.contentAsString).getLines.map(_.trim).toSeq
      def lineOpt(prefix: String) = lines.find(_.startsWith(prefix)).map(_.stripPrefix(prefix).stripSuffix(","))
      def lineFor(prefix: String) = lineOpt(prefix).getOrElse {
        throw new IllegalStateException(s"No line starting with [$prefix] available in [${src.name}].")
      }

      val key = src.name.stripSuffix(".lua")
      val name = nameFor(key)

      val width = lineFor("width = ").toInt
      val height = lineFor("height = ").toInt
      val greeting = lineOpt("greeting = ").map(clean)
      val noInventory = lineOpt("noinventory = ").map(clean)
      val noCommands = lineOpt("nocommands = ").map(clean)

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
