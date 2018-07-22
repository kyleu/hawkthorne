package pipeline

import io.circe.Json
import pipeline.file.ScalaFile
import util.JsonSerializers

object MapFiles {
  def process(cfg: PipelineConfig) = {
    val pkg = Seq("models", "data", "map")
    val file = ScalaFile(pkg = pkg, key = "TiledMap", root = Some("shared/src/main/scala"))

    file.addImport("enumeratum.values", "StringCirceEnum")
    file.addImport("enumeratum.values", "StringEnum")
    file.addImport("enumeratum.values", "StringEnumEntry")

    file.add("sealed abstract class TiledMap(", 2)
    val extras = "val soundtrack: String, val color: String, val images: Map[String, String]"
    file.add(s"override val value: String, val title: String, val width: Int, val height: Int, $extras")
    file.add(") extends StringEnumEntry", -2)
    file.add()

    file.add(s"object TiledMap extends StringEnum[TiledMap] with StringCirceEnum[TiledMap] {", 1)

    (cfg.src / "maps").children.filter(_.name.endsWith(".tmx")).toSeq.sortBy(_.name).foreach { src =>
      val key = src.name.stripSuffix(".tmx")
      val jsonFile = src.parent / "json" / (key + ".json")

      if (!jsonFile.exists) {
        import scala.sys.process._
        val app = "/Applications/Tiled.app/Contents/MacOS/Tiled"
        val cmd = s"$app --export-map ${cfg.src.path}/maps/$key.tmx ${cfg.src.path}/maps/json/$key.json"
        println(cmd)
        val result = cmd.!!
        println(result)
      }

      val name = nameFor(key)
      val json = JsonSerializers.parseJson(jsonFile.contentAsString).right.get.asObject.get

      val imageNames = json("tilesets").get.asArray.get.map(_.asObject.get).map { o =>
        val in = o.apply("name").get.asString.get
        val is = o.apply("image").get.asString.get
        in -> is.substring(is.lastIndexOf('/') + 1).stripSuffix(".png")
      }
      val imageString = imageNames.map(n => "\"" + n._1 + "\" -> \"" + n._2 + "\"").mkString(", ")

      val orientation = json("orientation").get.asString.get
      if (orientation != "orthogonal") { throw new IllegalStateException(s"Unhandled orientation [$orientation].") }
      val width = json("width").get.asNumber.get.toInt.get
      val height = json("height").get.asNumber.get.toInt.get

      val properties = json("properties").map(_.asObject.get).getOrElse(Json.obj().asObject.get)

      val soundtrack = properties("soundtrack").map(_.asString.get.stripPrefix("audio/music/").stripSuffix(".ogg"))
      val title = properties("title").map(_.asString.get).getOrElse(key)
      def extract(key: String) = properties(key).map(_.asString.get.toInt).getOrElse(0)
      val (r, g, b) = (extract("red"), extract("green"), extract("blue"))
      val color = "#%02x%02x%02x".format(r, g, b)

      val props = s"""title = "$title", width = $width, height = $height, soundtrack = "${soundtrack.getOrElse("level")}", color = "$color""""

      file.add(s"""case object $name extends TiledMap(value = "$key", $props, images = Map($imageString))""")
    }

    file.add()
    file.add("override val values = findValues")
    file.add("}", -1)

    cfg.writeScalaResult(s"maps", file.path -> file.rendered).toSeq ++ cfg.copyAsset("maps/json", "maps").toSeq
  }

  private[this] def nameFor(key: String) = key match {
    case "acschool" => "ACSchool"
    case "frozencave" => "FrozenCave"
    case "frozencave-2" => "FrozenCave2"
    case "greendale-englishmemorial" => "GreendaleEnglishMemorial"
    case "potteryclass" => "PotteryClass"
    case "secretwritersgarden" => "SecretWritersGarden"
    case "studyroom" => "StudyRoom"
    case "winterwonderland" => "WinterWonderland"
    case "winterwonderland2" => "WinterWonderland2"
    case _ => ExportHelper.toClassName(key)
  }
}
