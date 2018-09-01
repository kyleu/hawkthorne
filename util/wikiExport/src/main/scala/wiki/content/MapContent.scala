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
      ("Tilesets", o.tilesets.map(_.name).sorted.mkString(", "))
    ): _*)
  }
}
