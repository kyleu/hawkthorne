package util

import better.files.File

import scala.collection.immutable

object LuaUtils {
  def qualifies(f: File) = f.name.endsWith(".lua") && (f.name != "init.lua")

  def clean(s: String) = s.stripPrefix("'").stripPrefix("\"").stripSuffix(",").stripSuffix("'").stripSuffix("\"").replaceAllLiterally("\"", "\\\"")

  def lineNum(lines: IndexedSeq[String], prefix: String, offset: Int = 0) = {
    lines.zipWithIndex.drop(offset).find(_._1.startsWith(prefix)).map(_._2)
  }

  def lineOpt(lines: IndexedSeq[String], prefix: String, offset: Int = 0) = {
    lines.drop(offset).find(_.startsWith(prefix)).map(x => x.stripPrefix(prefix).stripSuffix(","))
  }

  def lineFor(src: String, lines: IndexedSeq[String], prefix: String, offset: Int = 0) = lineOpt(lines, prefix, offset).getOrElse {
    throw new IllegalStateException(s"No line starting with [$prefix] available in [$src].")
  }

  def findAnimations(lines: IndexedSeq[String]) = {
    lineNum(lines, "animations = ") match {
      case None => Nil
      case Some(startLine) =>
        Seq.empty[String]
    }
  }

  def findSounds(lines: immutable.IndexedSeq[String]) = lines.filter(_.startsWith("sound.playSfx")).map { l =>
    l.stripPrefix("sound.playSfx").stripPrefix("(").stripSuffix(")").replaceAllLiterally("'", "\"").trim
  }.distinct
}
