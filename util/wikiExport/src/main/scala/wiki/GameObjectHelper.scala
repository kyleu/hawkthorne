package wiki

object GameObjectHelper {
  def listingFile(cfg: WikiExportConfig, key: String, plural: String, names: Seq[String]) = {
    val title = s"${key}_Listing"
    val md = new MarkdownFile(dir = key.toLowerCase, title = title)
    md.add(s"Here are all of the ${plural.toLowerCase} in ${util.Version.projectName}.")
    names.foreach { name =>
      md.add(s"* [$name]($key${name.replaceAllLiterally(" ", "_")})")
    }
    cfg.writeMarkdownResult(title, md.path -> md.rendered).toSeq
  }

  def gameObjectFiles[T](
    cfg: WikiExportConfig, key: String, plural: String, all: Seq[T], k: T => String, n: T => String, i: T => Option[String], f: (T, MarkdownFile) => Unit
  ) = listingFile(cfg, key, plural, all.map(n)) ++ all.flatMap { o =>
    val md = new MarkdownFile(dir = key.toLowerCase, title = key + n(o))
    md.addHeader(n(o))
    i(o).foreach(img => md.add(MarkdownUtils.img(img, s"${k(o)} ${n(o)} texture")))
    f(o, md)
    cfg.writeMarkdownResult(k(o), md.path -> md.rendered)
  }
}
