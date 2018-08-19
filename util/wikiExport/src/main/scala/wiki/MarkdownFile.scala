package wiki

class MarkdownFile(val dir: String, val title: String) {
  val filename = title.stripSuffix(".md") + ".md"
  private[this] var hasRendered = false
  private[this] var currentIndent = 0
  private[this] val lines = collection.mutable.ArrayBuffer.empty[String]

  private[this] val markers = collection.mutable.HashMap.empty[String, Seq[String]]
  def markersFor(key: String) = markers.getOrElseUpdate(key, Nil)
  def addMarker(key: String, v: String) = markers(key) = markersFor(key) :+ v

  def indent(indentDelta: Int = 1): Unit = currentIndent += indentDelta

  def add(line: String = "", indentDelta: Int = 0): Unit = {
    if (hasRendered) {
      throw new IllegalStateException("Already rendered.")
    }
    if (indentDelta < 0) {
      currentIndent += indentDelta
    }
    val ws = if (line.trim.isEmpty) { "" } else { (0 until currentIndent).map(_ => "  ").mkString }
    if (indentDelta > 0) {
      currentIndent += indentDelta
    }

    lines += (ws + line + "\n")
  }

  def addHeader(s: String, level: Int = 1) = {
    add(s"${(0 until level).map(_ => "#").mkString} $s")
    add()
  }

  def addScala(lines: String*) = {
    add("```scala")
    lines.foreach(s => add(s))
    add("```")
  }

  val path = dir + "/" + filename

  def prefix: String = ""
  def suffix: String = ""

  lazy val rendered = {
    hasRendered = true
    prefix + lines.mkString + suffix
  }
}
