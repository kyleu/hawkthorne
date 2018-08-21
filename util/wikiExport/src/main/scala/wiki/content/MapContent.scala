package wiki.content

import models.data.map.TiledMap
import wiki.MarkdownFile

object MapContent {
  def apply(md: MarkdownFile, o: TiledMap) = {
    ContentHelper.attributes(md = md, Seq(
      ("Title", o.title),
      ("Width", o.width.toString),
      ("Height", o.height.toString),
      ("Soundtrack", o.soundtrack),
      ("Color", o.color),
      ("Images", o.images.keys.toSeq.sorted.mkString(", "))
    ): _*)
  }
}
