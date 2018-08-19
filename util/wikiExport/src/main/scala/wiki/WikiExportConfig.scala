package wiki

import better.files._
import util.JsonSerializers._

object WikiExportConfig {
  implicit val jsonEncoder: Encoder[WikiExportConfig] = deriveEncoder
  implicit val jsonDecoder: Decoder[WikiExportConfig] = deriveDecoder
}

final case class WikiExportConfig(tgtRootLoc: String, wipe: Boolean) {
  val tgt = {
    val f = tgtRootLoc.toFile
    if (!f.isDirectory) { throw new IllegalStateException(s"Target directory [$tgtRootLoc] is not valid.") }
    f
  }

  def writeMarkdown(tgtPath: String, content: String) = {
    val t = tgt / tgtPath
    if (t.exists && t.contentAsString == content) {
      None
    } else {
      t.parent.createIfNotExists(asDirectory = true, createParents = true)
      t.write(content)
      Some(tgt.relativize(t).toString)
    }
  }

  def writeMarkdownResult(src: String, pathContentFiles: (String, String)*) = {
    val f = WikiExportResult.File(src, pathContentFiles.flatMap(f => writeMarkdown(f._1, f._2)))
    if (f.tgts.isEmpty) {
      None
    } else {
      Some(f)
    }
  }
}
