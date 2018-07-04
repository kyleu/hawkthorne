package pipeline

import io.circe.Json
import pipeline.file.ScalaFile
import util.JsonSerializers._

object AnimationFiles {
  def process(cfg: PipelineConfig) = {
    val src = cfg.src / "character_map.json"
    val json = decodeJson[Json](src.contentAsString).right.get.asObject.get

    val pkg = Seq("models", "data")
    val file = ScalaFile(pkg = pkg, key = "Animation", root = Some("shared/src/main/scala"))

    file.addImport("enumeratum.values", "StringEnum")
    file.addImport("enumeratum.values", "StringEnumEntry")

    file.add("sealed abstract class Animation(", 2)
    file.add("override val value: String")
    file.add(") extends StringEnumEntry", -2)
    file.add()

    file.add(s"object Animation extends StringEnum[Animation] {", 1)

    json.keys.foreach { key =>
      val (l, r) = json.apply(key).get.asObject.map { o =>
        o("left").get.asArray.get -> o("right").get.asArray.get
      }.getOrElse {
        val x = json.apply(key).get
        x -> x
      }
      file.add(s"case object ${ExportHelper.toClassName(key)} extends Animation(", 1)
      file.add(s"""value = "$key"""")
      file.add(")", -1)
    }

    file.add()
    file.add("override val values = findValues")
    file.add("}", -1)

    cfg.writeScalaResult(s"character_map.json", file.path -> file.rendered).toSeq
  }
}
