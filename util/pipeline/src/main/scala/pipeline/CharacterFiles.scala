package pipeline

import pipeline.file.ScalaFile
import util.JsonSerializers._

object CharacterFiles {
  def process(cfg: PipelineConfig) = {
    (cfg.src / "characters").children.filter(_.name.endsWith(".json")).toSeq.flatMap { src =>
      val json = parseJson(src.contentAsString).asObject.get
      val key = src.name.stripSuffix(".json")
      val name = nameFor(key)
      val costumes = jsonToObj[Seq[Json]](json("costumes").get)

      val pkg = Seq("models", "data", "character")
      val file = ScalaFile(pkg = pkg, key = name, root = Some("shared/src/main/scala"))

      file.addImport("models.player", "Costume")
      file.addImport("util", "BoundingBox")
      file.addImport("models.template.character", "CharacterTemplate")
      file.addImport("models.data.series", "Episode")

      file.add(s"object $name extends CharacterTemplate(", 1)
      file.add(s"""key = "$key",""")
      file.add(s"""name = "$name",""")
      file.add(s"""givenName = "${costumes.head.asObject.get.apply("name").get.asString.get}",""")
      file.add()
      file.add("costumes = Seq(", 1)
      costumes.foreach { c =>
        val comma = if (costumes.lastOption.contains(c)) { "" } else { "," }
        val cos = c.asObject.get
        val cat = cos("category").get.asString.get match {
          case "base" => "S03E20"
          case "fanmade" => "S00E01"
          case "s4promo" => "S04E01"
          case x => x.stripPrefix("s").split("e").toList match {
            case seasonNum :: epNum :: Nil => s"S0${seasonNum}E${if (epNum.toInt < 10) { "0" } else { "" }}$epNum"
            case u => throw new IllegalStateException("Unhandled: " + u)
          }
        }
        val n = cos("name").get.asString.get
        val s = cos("sheet").get.asString.get
        val o = cos("ow").get.asNumber.get.toInt.get
        file.add(s"""Costume("$s", Episode.$cat, "$n", $o)$comma""")
      }
      file.add("),", -1)
      file.add()
      val bb = json("bbox").get.asObject.get
      file.add("boundingBox = BoundingBox(", 1)
      file.add(s"width = ${bb("width").get},")
      file.add(s"height = ${bb("height").get},")
      file.add(s"duckHeight = ${bb("duck_height").get},")
      file.add(s"x = ${bb("x").get},")
      file.add(s"y = ${bb("y").get}")
      file.add("),", -1)
      file.add(s"offset = ${json("offset").get}")
      file.add(")", -1)

      cfg.writeScalaResult(s"characters/${src.name}", file.path -> file.rendered)
    }
  }

  private[this] def nameFor(key: String) = key match {
    case "fatneil" => "FatNeil"
    case "vicedean" => "ViceDean"
    case _ => ExportHelper.toClassName(key)
  }
}
