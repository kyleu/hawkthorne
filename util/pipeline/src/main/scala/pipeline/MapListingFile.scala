package pipeline

import better.files.File
import pipeline.file.ScalaFile
import util.JsonSerializers

object MapListingFile {
  def getJson(cfgSrc: File) = (cfgSrc / "maps").children.filter(_.name.endsWith(".tmx")).toSeq.sortBy(_.name).map { src =>
    val key = src.name.stripSuffix(".tmx")
    val jsonFile = src.parent / "json" / (key + ".json")

    if (!jsonFile.exists) {
      import scala.sys.process._
      val app = "/Applications/Tiled.app/Contents/MacOS/Tiled"
      val cmd = s"$app --export-map ${cfgSrc.path}/maps/$key.tmx ${cfgSrc.path}/maps/json/$key.json"
      cmd.!!
    }

    (key, nameFor(key), JsonSerializers.parseJson(jsonFile.contentAsString).asObject.get)
  }

  def process(cfg: PipelineConfig) = {
    val pkg = Seq("models", "data", "map")
    val file = ScalaFile(pkg = pkg, key = "TiledMap", root = Some("shared/src/main/scala"))

    file.addImport("enumeratum.values", "StringCirceEnum")
    file.addImport("enumeratum.values", "StringEnum")
    file.addImport("enumeratum.values", "StringEnumEntry")

    file.add("sealed abstract class TiledMap(override val value: String, val width: Int, val height: Int, val details: TiledMapDetails) extends StringEnumEntry")
    file.add()

    file.add(s"object TiledMap extends StringEnum[TiledMap] with StringCirceEnum[TiledMap] {", 1)

    getJson(cfg.src).foreach {
      case (key, name, json) =>
        val width = json("width").get.asNumber.get.toInt.get
        val height = json("height").get.asNumber.get.toInt.get

        file.add(s"""case object $name extends TiledMap(value = "$key", width = $width, height = $height, details = ${name}Details)""")
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
