package pipeline

import util.JsonSerializers._
import better.files._

object PipelineConfig {
  implicit val jsonEncoder: Encoder[PipelineConfig] = deriveEncoder
  implicit val jsonDecoder: Decoder[PipelineConfig] = deriveDecoder
}

case class PipelineConfig(
    srcProjectLoc: String,
    tgtRootLoc: String
) {
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
  val scalaRoot = tgt / "app" / "models" / "data"

  def writeScala(tgtPath: String, content: String) = {
    val t = tgt / tgtPath
    t.parent.createIfNotExists(asDirectory = true, createParents = true)
    t.write(content)
    tgt.relativize(t).toString
  }

  def copyAsset(srcPath: String, tgtPath: String) = {
    val s = src / srcPath
    val t = assetRoot / tgtPath
    t.parent.createIfNotExists(asDirectory = true, createParents = true)
    s.copyTo(t)
    PipelineResult.File(src.relativize(s).toString, Seq(tgt.relativize(t).toString))
  }
}
