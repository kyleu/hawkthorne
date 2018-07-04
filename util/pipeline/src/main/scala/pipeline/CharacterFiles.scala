package pipeline

import pipeline.file.ScalaFile
import util.JsonSerializers._

object CharacterFiles {
  def process(cfg: PipelineConfig) = {
    (cfg.src / "characters").children.filter(_.name.endsWith(".json")).toSeq.map { src =>
      val json = decodeJson[Json](src.contentAsString).right.get.asObject.get
      val key = src.name.stripSuffix(".json")
      val name = nameFor(key)
      val costumes = json("costumes").get.as[Seq[Json]].right.get

      val pkg = Seq("models", "data", "character")
      val file = ScalaFile(pkg = pkg, key = name)

      file.addImport("models.character", "Costume")
      file.addImport("models.character", "BoundingBox")
      file.addImport("models.character", "CharacterTemplate")

      file.add(s"object $name {", 1)
      file.add(s"""val name = "$name"""")
      file.add(s"""val givenName = "${costumes.head.asObject.get.apply("name").get.asString.get}"""")
      file.add()
      file.add("val costumes = Seq(", 1)
      costumes.foreach { c =>
        val comma = if (costumes.lastOption.contains(c)) { "" } else { "," }
        val cos = c.asObject.get
        val cat = cos("category").get.asString.get
        val n = cos("name").get.asString.get
        val s = cos("sheet").get.asString.get
        val o = cos("ow").get.asNumber.get.toInt.get
        file.add(s"""Costume("$s", "$cat", "$n", $o)$comma""")
      }
      file.add(")", -1)
      file.add()
      val bb = json("bbox").get.asObject.get
      file.add("val boundingBox = BoundingBox(", 1)
      file.add(s"width = ${bb("width").get},")
      file.add(s"height = ${bb("height").get},")
      file.add(s"duckHeight = ${bb("duck_height").get},")
      file.add(s"x = ${bb("x").get},")
      file.add(s"y = ${bb("y").get}")
      file.add(")", -1)
      file.add(s"val offset = ${json("offset").get}")
      file.add()
      file.add(s"""val template = CharacterTemplate("$key", name, givenName, costumes, boundingBox, offset)""")
      file.add("}", -1)

      PipelineResult.File(s"characters/${src.name}", Seq(
        cfg.writeScala(file.path, file.rendered)
      ))
    }
  }

  private[this] def nameFor(key: String) = key match {
    case "fatneil" => "FatNeil"
    case "vicedean" => "ViceDean"
    case _ => ExportHelper.toClassName(key)
  }
}
