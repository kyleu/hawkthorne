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

    val t = "Seq[(Int, Int)]"
    file.add(s"sealed abstract class Animation(", 1)
    file.add("override val value: String, val left: Seq[(Int, Int)], val right: Seq[(Int, Int)], val duration: Double, val loop: Boolean")
    file.add(") extends StringEnumEntry", -1)
    file.add()
    file.add(s"object Animation extends StringEnum[Animation] {", 1)
    json.keys.toSeq.sorted.foreach { key =>
      val (l, r) = json.apply(key).get.asObject.map { o =>
        o("left").get.asArray.get -> o("right").get.asArray.get
      }.getOrElse {
        val x = json.apply(key).get.asArray.get
        x -> x
      }
      val left = processCoords(l.apply(1).asArray.get)
      val right = processCoords(r.apply(1).asArray.get)
      val duration = l.apply(2).asNumber.get.toDouble
      val loop = l.apply(0).asString.get == "loop"
      val anim = s"""Animation(value = "$key", left = $left, right = $right, duration = $duration, loop = $loop)"""
      file.add(s"case object ${ExportHelper.toClassName(clean(key))} extends $anim")
    }
    file.add()
    file.add("override val values = findValues")
    file.add("}", -1)
    cfg.writeScalaResult(s"character_map.json", file.path -> file.rendered).toSeq
  }

  private[this] val words = Set(
    "walk", "jump", "idle", "arrow", "away", "action", "pistol", "hold", "gaze", "throw"
  ).map(x => x -> (x.head.toUpper + x.tail))

  private[this] def clean(s: String) = words.foldLeft(s)((in, el) => in.replaceAllLiterally(el._1, el._2))

  private[this] def processCoords(coords: Seq[Json]) = {
    val values = coords.foldLeft(Seq.empty[(Int, Int)]) { (ret, c) =>
      val newCoords = c.asString.get.split(',').toList match {
        case x :: y :: Nil if x.contains('-') => x.split('-').toList match {
          case start :: end :: Nil => (start.toInt to end.toInt).map(subX => subX -> y.toInt)
          case _ => throw new IllegalStateException(s"Illegal range [$x].")
        }
        case x :: y :: Nil => Seq(x.toInt -> y.toInt)
        case x => throw new IllegalStateException(s"Illegal coords [${x.mkString(",")}].")
      }
      ret ++ newCoords
    }
    s"Seq(${values.map(v => s"(${v._1}, ${v._2})").mkString(", ")})"
  }
}
