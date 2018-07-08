package pipeline

import pipeline.file.ScalaFile
import util.JsonSerializers._

object EpisodeFiles {
  def process(cfg: PipelineConfig) = {
    val src = scala.io.Source.fromInputStream(getClass.getClassLoader.getResourceAsStream("episodes.json")).mkString
    val json = decodeJson[Json](src).right.get.asArray.get

    val pkg = Seq("models", "data", "series")
    val file = ScalaFile(pkg = pkg, key = "Episode", root = Some("shared/src/main/scala"))

    file.addImport("java.time", "LocalDate")
    file.addImport("enumeratum.values", "StringEnum")
    file.addImport("enumeratum.values", "StringCirceEnum")
    file.addImport("enumeratum.values", "StringEnumEntry")

    file.add("sealed abstract class Episode(", 2)
    file.add("override val value: String, val season: Int, val episodeNum: Int, val name: String, val aired: LocalDate, val summary: String")
    file.add(") extends StringEnumEntry", -2)
    file.add()

    file.add(s"object Episode extends StringEnum[Episode] with StringCirceEnum[Episode] {", 1)

    json.map { e =>
      val o = e.asObject.get
      val seasonNum = o("airedSeason").get.asNumber.get.toInt.get
      val epNum = o("airedEpisodeNumber").get.asNumber.get.toInt.get
      (seasonNum, epNum, o)
    }.sortBy(x => x._1 -> x._2).foreach {
      case (seasonNum, epNum, o) =>
        val key = s"S0${seasonNum}E${if (epNum < 10) { "0" } else { "" }}$epNum"
        val name = o("episodeName").get.asString.get
        val airDate = o("firstAired").get.asString.get
        val summary = o("overview").get.asString.get.replaceAllLiterally("\n", " ").replaceAllLiterally("\r", " ").replaceAllLiterally("\"", "\\\"").replaceAllLiterally("  ", " ")
        file.add(s"case object $key extends Episode(", 1)
        file.add(s"""value = "$key", season = $seasonNum, episodeNum = $epNum, name = "$name", aired = LocalDate.parse("$airDate"),""")
        file.add(s"""summary = "$summary"""")
        file.add(")", -1)
    }

    file.add()
    file.add("override val values = findValues")
    file.add("}", -1)

    cfg.writeScalaResult("episodes.json", file.path -> file.rendered).toSeq
  }
}
