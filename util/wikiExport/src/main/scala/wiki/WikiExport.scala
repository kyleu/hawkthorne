package wiki

import models.template.npc.{NpcListing, NpcTemplate}
import models.template.weapon.{WeaponListing, WeaponTemplate}
import util.JsonSerializers._

object WikiExport {
  private[this] def testFile(cfg: WikiExportConfig) = {
    val title = "Wiki Test Page"
    val md = new MarkdownFile(dir = ".", title = title)
    md.addHeader(title)
    md.add("This wiki is machine-generated work-in-progress. Be advised.")
    md.add()
    md.addScala("println(1)")
    md.add()
    md.add("Good luck!")
    cfg.writeMarkdownResult(title, md.path -> md.rendered)
  }

  def main(args: Array[String]): Unit = {
    val started = util.DateUtils.now
    val startNanos = System.nanoTime

    val cfg = WikiExportConfig(tgtRootLoc = "./wiki", wipe = false)
    val files = Seq(GameObjectFiles.all(cfg), testFile(cfg).toSeq).flatten
    val result = WikiExportResult(config = cfg, started = started, durationNanos = System.nanoTime - startNanos, files = files)
    println(result.asJson.spaces2)
  }
}
