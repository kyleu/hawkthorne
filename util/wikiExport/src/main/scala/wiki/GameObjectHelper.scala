package wiki

import wiki.content.ContentHelper

object GameObjectHelper {
  case class Params[T](
      cfg: WikiExportConfig,
      key: String,
      dirOverride: Option[String] = None,
      plural: String,
      extras: Seq[String] = Nil,
      all: Seq[T],
      k: T => String,
      n: T => (String, String),
      i: T => Option[String],
      f: (T, MarkdownFile) => Unit
  ) {
    val dir = dirOverride.getOrElse(key.toLowerCase)
  }

  def listingFile(p: Params[_], names: Seq[(String, String)]) = {
    val title = s"${p.key}_Listing"
    val md = new MarkdownFile(dir = p.dir, title = title)
    md.add(s"Here are all of the ${p.plural.toLowerCase} in ${util.Version.projectName}.")
    p.extras.foreach { e =>
      md.add()
      md.add(e)
    }
    md.add()
    ContentHelper.table(md = md, cols = Seq(('l', 20, ""), ('l', 20, "Name")), content = names.map { x =>
      Seq(s"[${x._1}](${p.key}${x._1.replaceAllLiterally(" ", "_")})", x._2)
    })
    p.cfg.writeMarkdownResult(title, md.path -> md.rendered).toSeq
  }

  def gameObjectFiles[T](p: Params[T]) = {
    listingFile(p, p.all.sortBy(x => p.n(x)._1).map(p.n)) ++ p.all.flatMap { o =>
      val md = new MarkdownFile(dir = p.dir, title = p.key + p.n(o)._1)
      md.addHeader(p.n(o)._2)
      p.i(o).foreach(img => md.add(ContentHelper.img(img, s"${p.k(o)} ${p.n(o)._1} texture")))
      p.f(o, md)
      p.cfg.writeMarkdownResult(p.k(o), md.path -> md.rendered)
    }
  }
}
