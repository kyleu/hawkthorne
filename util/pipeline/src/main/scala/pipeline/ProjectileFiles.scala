package pipeline

import pipeline.file.{ListingFile, ScalaFile}
import util.LuaUtils

import scala.io.Source

object ProjectileFiles {
  def process(cfg: PipelineConfig) = {
    val files = (cfg.src / "nodes" / "projectiles").children.filter(LuaUtils.qualifies).toSeq.map { src =>
      val lines = Source.fromString(src.contentAsString).getLines.map(_.trim).toIndexedSeq

      val key = src.name.stripSuffix(".lua")
      val name = nameFor(key)

      val width = LuaUtils.lineFor(src.name, lines, "width = ").toInt
      val height = LuaUtils.lineFor(src.name, lines, "height = ").trim.toInt

      val pkg = Seq("models", "data", "projectile")
      val file = ScalaFile(pkg = pkg, key = name, root = Some("shared/src/main/scala"))

      file.addImport("models.projectile", "ProjectileTemplate")

      file.add(s"object $name extends ProjectileTemplate(", 1)
      file.add(s"""key = "$key",""")
      file.add(s"""name = "$name",""")
      file.add(s"""width = $width,""")
      file.add(s"""height = $height,""")
      file.add(s"""animations = Seq.empty""")
      file.add(")", -1)

      name -> cfg.writeScalaResult(s"projectile/${src.name}", file.path -> file.rendered)
    }
    ListingFile.listingFile(cfg, "projectile", files.map(_._1)) ++ files.flatMap(_._2)
  }

  private[this] def nameFor(key: String) = key match {
    case "bomb-longrange" => "BombLongRange"
    case "birdbomb" => "BirdBomb"
    case "cloudbomb" => "CloudBomb"
    case "cloudbomb_horizontal" => "CloudBombHorizontal"
    case "lasercell" => "LaserCell"
    case "rainbowbeam" => "RainbowBeam"
    case "rainbowbeam_tsnake" => "RainbowBeamTSnake"
    case "throwingaxe" => "ThrowingAxe"
    case "throwingknife" => "ThrowingKnife"
    case "throwingtorch" => "ThrowingTorch"
    case _ => ExportHelper.toClassName(key)
  }
}
