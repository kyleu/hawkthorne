package pipeline

import pipeline.file.{ListingFile, ScalaFile}
import util.LuaUtils

import scala.io.Source

object NpcFiles {
  def process(cfg: PipelineConfig) = {
    val files = (cfg.src / "npcs").children.filter(LuaUtils.qualifies).toSeq.map { src =>
      val lines = Source.fromString(src.contentAsString).getLines.map(_.trim).toIndexedSeq

      val key = src.name.stripSuffix(".lua")
      val name = nameFor(key)

      val width = LuaUtils.lineFor(src.name, lines, "width = ").toInt
      val height = LuaUtils.lineFor(src.name, lines, "height = ").toInt

      val greeting = LuaUtils.lineOpt(lines, "greeting = ").map(LuaUtils.clean)
      val noInventory = LuaUtils.lineOpt(lines, "noinventory = ").map(LuaUtils.clean)
      val noCommands = LuaUtils.lineOpt(lines, "nocommands = ").map(LuaUtils.clean)

      val responses = NpcHelper.getResponses(key, LuaUtils.blockFor(key, lines, "talk_responses = "))
      val talkItems = NpcHelper.talkItems(key, LuaUtils.blockFor(key, lines, "talk_items = "), responses)

      val pkg = Seq("models", "data", "npc")
      val file = ScalaFile(pkg = pkg, key = name, root = Some("shared/src/main/scala"))

      file.addImport("models.animation", "Animation")
      file.addImport("models.template.npc", "NpcTemplate")
      file.addImport("models.npc", "TalkItem")

      file.add(s"object $name extends NpcTemplate(", 1)
      file.add(s"""key = "$key",""")
      file.add(s"""name = "$name",""")
      file.add(s"""width = $width,""")
      file.add(s"""height = $height,""")
      file.add(s"""greeting = ${greeting.map("Some(\"" + _ + "\")").getOrElse("None")},""")
      val anims = LuaUtils.findAnimations("Npc: " + name, lines)
      if (anims.isEmpty) {
        file.add(s"animations = Seq.empty,")
      } else {
        file.add(s"animations = Seq(", 1)
        anims.foreach(a => file.add(a))
        file.add(s"),", -1)
      }
      file.add(s"noInventory = ${noInventory.map("Some(\"" + _ + "\")").getOrElse("None")},")
      file.add(s"noCommands = ${noCommands.map("Some(\"" + _ + "\")").getOrElse("None")},")
      if (talkItems.isEmpty) {
        file.add("talkItems = Seq.empty[TalkItem]")
      } else {
        file.add("talkItems = Seq[TalkItem](", 1)
        file.add(talkItems.mkString("\n    "))
        file.add(")", -1)
      }
      file.add(")", -1)

      name -> cfg.writeScalaResult(s"npcs/${src.name}", file.path -> file.rendered)
    }
    ListingFile.listingFile(cfg, "npc", files.map(_._1)) ++ files.flatMap(_._2)
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
