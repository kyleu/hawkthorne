package pipeline

import pipeline.file.{ListingFile, ScalaFile}
import util.LuaUtils

import scala.io.Source

object WeaponFiles {
  def process(cfg: PipelineConfig) = {
    val files = (cfg.src / "nodes" / "weapons").children.filter(LuaUtils.qualifies).toSeq.map { src =>
      val lines = Source.fromString(src.contentAsString).getLines.map(_.trim).toIndexedSeq

      val key = src.name.stripSuffix(".lua")
      val name = nameFor(key)

      val width = LuaUtils.lineFor(src.name, lines, "width = ").toInt
      val height = LuaUtils.lineFor(src.name, lines, "height = ").toInt

      val pkg = Seq("models", "data", "weapon")
      val file = ScalaFile(pkg = pkg, key = name, root = Some("shared/src/main/scala"))

      file.addImport("models.template.weapon", "WeaponTemplate")

      file.add(s"object $name extends WeaponTemplate(", 1)
      file.add(s"""key = "$key",""")
      file.add(s"""name = "$name",""")
      file.add(s"width = $width,")
      file.add(s"height = $height,")

      val anims = LuaUtils.findAnimations(lines)
      if (anims.isEmpty) {
        file.add(s"animations = Seq.empty")
      } else {
        file.add(s"animations = Seq(", 1)
        anims.foreach(a => file.add(a))
        file.add(s")", -1)
      }

      file.add(s")", -1)

      file.add(")", -1)

      name -> cfg.writeScalaResult(s"weapons/${src.name}", file.path -> file.rendered)
    }
    ListingFile.listingFile(cfg, "weapon", files.map(_._1)) ++ files.flatMap(_._2)
  }

  private[this] def nameFor(key: String) = key match {
    case "blueskyspecial" => "BlueSkySpecial"
    case "boneclub" => "BoneClub"
    case "cherrypopper" => "CherryPopper"
    case "truestwrench" => "TruestWrench"
    case _ => ExportHelper.toClassName(key)
  }
}
