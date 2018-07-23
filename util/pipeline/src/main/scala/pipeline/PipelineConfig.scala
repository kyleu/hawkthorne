package pipeline

import util.JsonSerializers._
import better.files._

object PipelineConfig {
  implicit val jsonEncoder: Encoder[PipelineConfig] = deriveEncoder
  implicit val jsonDecoder: Decoder[PipelineConfig] = deriveDecoder
}

final case class PipelineConfig(srcProjectLoc: String, tgtRootLoc: String, wipe: Boolean) {
  val src = {
    val f = srcProjectLoc.toFile
    if (!f.isDirectory) { throw new IllegalStateException(s"Source directory [$srcProjectLoc] is not valid.") }
    f
  }
  val tgt = {
    val f = tgtRootLoc.toFile
    if (!f.isDirectory) { throw new IllegalStateException(s"Target directory [$tgtRootLoc] is not valid.") }
    f
  }

  val assetRoot = tgt / "public" / "game"
  val scalaAppRoot = tgt / "app" / "models" / "data"
  val scalaSharedRoot = tgt / "shared" / "src" / "main" / "scala" / "models" / "data"

  def writeScala(tgtPath: String, content: String) = {
    val t = tgt / tgtPath
    if (t.exists && t.contentAsString == content) {
      None
    } else {
      t.parent.createIfNotExists(asDirectory = true, createParents = true)
      t.write(content)
      Some(tgt.relativize(t).toString)
    }
  }

  def writeScalaResult(src: String, pathContentFiles: (String, String)*) = {
    val f = PipelineResult.File(src, pathContentFiles.flatMap(f => writeScala(f._1, f._2)))
    if (f.tgts.isEmpty) {
      None
    } else {
      Some(f)
    }
  }

  def copyAsset(srcPath: String, tgtPath: String) = {
    val s = src / srcPath
    val t = assetRoot / tgtPath
    if (t.exists) {
      None
    } else {
      t.parent.createIfNotExists(asDirectory = true, createParents = true)
      s.copyTo(t)
      Some(PipelineResult.File(src.relativize(s).toString, Seq(tgt.relativize(t).toString)))
    }
  }
}
