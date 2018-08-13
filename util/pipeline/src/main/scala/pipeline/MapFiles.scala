package pipeline

import io.circe.Json
import pipeline.file.ScalaFile

object MapFiles {
  def process(cfg: PipelineConfig) = MapListingFile.getJson(cfg.src).flatMap {
    case (key, name, json) =>
      val pkg = Seq("models", "data", "map")
      val file = ScalaFile(pkg = pkg, key = s"${name}Details", root = Some("shared/src/main/scala"))

      val imageNames = json("tilesets").get.asArray.get.map(_.asObject.get).map { o =>
        val in = o.apply("name").get.asString.get
        val is = o.apply("image").get.asString.get
        in -> is.substring(is.lastIndexOf('/') + 1).stripSuffix(".png")
      }

      val imageString = imageNames.filterNot(_._1 == "collisions").map(n => "\"" + n._1 + "\" -> \"" + n._2 + "\"").mkString(", ")

      val orientation = json("orientation").get.asString.get
      if (orientation != "orthogonal") { throw new IllegalStateException(s"Unhandled orientation [$orientation].") }

      val properties = json("properties").map(_.asObject.get).getOrElse(Json.obj().asObject.get)

      val soundtrack = properties("soundtrack").map(_.asString.get.stripPrefix("audio/music/").stripSuffix(".ogg"))
      val title = properties("title").map(_.asString.get).getOrElse(key)
      def extract(key: String) = properties(key).map(_.asString.get.toInt).getOrElse(0)
      val (r, g, b) = (extract("red"), extract("green"), extract("blue"))
      val color = "#%02x%02x%02x".format(r, g, b)

      file.add(s"object ${name}Details extends TiledMapDetails(", 1)
      file.add(s"""key = "$key",""")
      file.add(s"""title = "$title",""")
      file.add(s"""soundtrack = "${soundtrack.getOrElse("level")}",""")
      file.add(s"""color = "$color",""")
      file.add(s"""images = Map($imageString)""")
      file.add(")", -1)

      cfg.writeScalaResult("maps", file.path -> file.rendered)
  } ++ MapListingFile.process(cfg)

}
