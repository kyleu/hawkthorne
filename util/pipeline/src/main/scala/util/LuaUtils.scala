package util

import better.files.File

object LuaUtils {
  def qualifies(f: File) = f.name.endsWith(".lua") && (f.name != "init.lua")

  def clean(s: String) = s.stripPrefix("'").stripPrefix("\"").stripSuffix(",").stripSuffix("'").stripSuffix("\"").replaceAllLiterally("\"", "\\\"")

  def lineOpt(lines: IndexedSeq[String], prefix: String) = lines.find(_.startsWith(prefix)).map(_.stripPrefix(prefix).stripSuffix(","))

  def lineFor(src: String, lines: IndexedSeq[String], prefix: String) = lineOpt(lines, prefix).getOrElse {
    throw new IllegalStateException(s"No line starting with [$prefix] available in [$src].")
  }
}
