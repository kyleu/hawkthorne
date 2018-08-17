package util

import better.files.File

import scala.collection.immutable
import scala.util.control.NonFatal

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

  def blockFor(src: String, lines: immutable.IndexedSeq[String], prefix: String) = {
    val lineNumber = lineNum(lines, prefix).getOrElse(throw new IllegalStateException(s"Cannot find [$src] line starting with [$prefix]"))

    var bracketDepth = 0
    lines.drop(lineNumber).takeWhile { line =>
      val opens = line.count(c => c == '{')
      val closes = line.count(c => c == '}')
      bracketDepth = bracketDepth + opens - closes
      bracketDepth > 0
    }
  }

  def findAnimations(ctx: String, lines: IndexedSeq[String]) = {
    lineNum(lines, "animations = ") match {
      case None => Nil
      case Some(startLine) =>
        var depth = 0
        val matched = lines.drop(startLine).takeWhile { l =>
          depth += l.count(_ == '{')
          depth -= l.count(_ == '}')
          depth > 0
        }.map(_.trim.stripSuffix(",")).dropWhile(_ == "animations = {")

        var acc = Seq.empty[String]
        val anims = matched.flatMap { line =>
          line.count(_ == '{') - line.count(_ == '}') match {
            case _ if line.isEmpty || line.startsWith("--") => None
            case 1 if line.contains('=') =>
              acc = acc :+ line.substring(0, line.indexOf('=')).trim
              None
            case 0 if line.contains('=') => Some(parseAnimationLine(acc.map(_ + ".").mkString + line))
            case 0 if acc.nonEmpty => Some(parseAnimationLine(acc.mkString(".") + " = " + line))
            case -1 =>
              acc = acc.drop(1)
              None
            case x => throw new IllegalStateException(s"Unbalanced $ctx line [$line] with $x results.")
          }
        }
        anims.dropRight(1).map(_ + ",") :+ anims.last
    }
  }

  private[this] def parseAnimationLine(line: String) = try {
    val id = line.takeWhile(_ != '=').trim
    val cleaned = line.dropWhile(_ != '=').trim.stripPrefix("=").trim.stripPrefix("{").stripSuffix(",").stripSuffix("}").trim
    val typ = cleaned.substring(0, cleaned.indexOf(',')).replaceAllLiterally("'", "").trim
    val delay = cleaned.substring(cleaned.lastIndexOf(',') + 1).trim.toDouble
    val coordString = cleaned.substring(cleaned.indexOf(',') + 1, cleaned.lastIndexOf(',')).trim.stripPrefix("{").stripSuffix("}").stripSuffix(",").trim
    val coords = parseCoords(coordString)
    val stride = coords.map(_._1).max + 1
    val frames = coords.map(c => c._1 + (c._2 * stride))
    s"""Animation(id = "$id", frames = IndexedSeq(${frames.mkString(", ")}), delay = $delay, loop = ${typ == "loop"})"""
  } catch {
    case NonFatal(x) => throw new IllegalStateException(s"Error processing line [$line]", x)
  }

  private[this] def from(start: Int, end: Int) = if (start < end) { start to end } else { end to start }
  private[this] def parseCoords(s: String) = {
    val ret = s.split("',").map(_.trim.stripPrefix("'").stripSuffix("'").trim).foldLeft(IndexedSeq.empty[(Int, Int)]) { (ret, c) =>
      val newCoords = c.split(',').toList match {
        case x :: y :: Nil if x.contains('-') || y.contains('-') =>
          val xs = x.split('-').map(_.trim).toList match {
            case start :: end :: Nil => from(start.toInt, end.toInt)
            case solo :: Nil => Seq(solo.toInt)
            case _ => throw new IllegalStateException(s"Illegal x range [$x].")
          }
          val ys = y.split('-').map(_.trim).toList match {
            case start :: end :: Nil => from(start.toInt, end.toInt)
            case solo :: Nil => Seq(solo.toInt)
            case _ => throw new IllegalStateException(s"Illegal y range [$y].")
          }
          xs.flatMap(x => ys.map(y => x -> y))
        case x :: y :: Nil => Seq(x.trim.toInt -> y.trim.toInt)
        case x => throw new IllegalStateException(s"Illegal coords [${x.mkString(",")}].")
      }
      ret ++ newCoords
    }.map(x => (x._1 - 1) -> (x._2 - 1))
    if (ret.isEmpty) {
      throw new IllegalStateException(s"Invalid animation string [$s].")
    }
    ret
  }

  def findSounds(lines: immutable.IndexedSeq[String]) = lines.filter(_.startsWith("sound.playSfx")).map { l =>
    l.stripPrefix("sound.playSfx").stripPrefix("(").stripSuffix(")").replaceAllLiterally("'", "\"").trim
  }.distinct
}
