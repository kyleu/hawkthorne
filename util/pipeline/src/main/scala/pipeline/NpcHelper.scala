package pipeline

object NpcHelper {
  private[this] def brackets(line: String) = Math.max(-1, Math.min(1, line.count(c => c == '{') - line.count(c => c == '}')))
  private[this] def quoteProper(s: String) = "\"" + s.headOption.map(_.toUpper.toString + s.tail).getOrElse("") + "\""

  private[this] def stripContainer(lines: Seq[String], prefix: String) = lines.head match {
    case x if x.startsWith(prefix) => lines.tail
    case _ => throw new IllegalStateException(s"Block does not start with prefix [$prefix]")
  }

  private[this] def getText(key: String, line: String) = line.indexOf("['text']") match {
    case -1 => throw new IllegalStateException(s"No ['text'] in line [$line] for [$key]")
    case x =>
      val t = line.substring(x + 9).trim.stripPrefix("'").stripPrefix("\"").stripSuffix(",").stripSuffix("\"").stripSuffix("'").trim
      t.indexOf("',") match {
        case -1 => t
        case idx => t.substring(0, idx)
      }
  }

  def getResponses(key: String, block: Seq[String]) = {
    var curr = "?"
    var acc = Seq.empty[String]
    block.flatMap { line =>
      brackets(line) match {
        case 0 =>
          acc = acc :+ line.stripSuffix(",").stripPrefix("\"").stripSuffix("\"").stripSuffix(",").trim
          None
        case x if x > 0 =>
          curr = line.trim.stripPrefix("[").stripPrefix("'").stripPrefix("\"").stripSuffix("{").trim
            .stripSuffix("=").trim.stripSuffix("]").trim.stripSuffix("\"").stripSuffix("'")
          None
        case x if x < 0 =>
          val ret = Some(curr -> acc)
          curr = "?"
          acc = Nil
          ret
      }
    }.toMap
  }

  def talkItems(key: String, block: Seq[String], responses: Map[String, Seq[String]]) = {
    var bracketDepth = brackets(block.head)
    def bracketWs = (0 until (bracketDepth - 1)).map(_ => "  ").mkString
    def getResponses(text: String) = responses.get(text.stripPrefix("\"").stripSuffix("\"")) match {
      case Some(r) => s"List(${r.map(quoteProper).mkString(", ")})"
      case None => "Nil"
    }
    def simpleItem(line: String, comma: Boolean) = {
      val text = quoteProper(getText(key, line))
      s"${bracketWs}TalkItem(prompt = $text, responses = ${getResponses(text)})${if (comma) { "," } else { "" }}"
    }
    def optionsItem(line: String) = {
      val text = getText(key, line)
      s"${bracketWs.stripSuffix("  ")}TalkItem(prompt = ${quoteProper(text)}, responses = ${getResponses(text)}, children = Seq("
    }
    def trim(s: String) = s.trim.stripPrefix("{").stripSuffix(",").trim.stripSuffix("}")

    val strippedBlock = stripContainer(block.map(trim).filter(_.nonEmpty), "talk_items")
    strippedBlock.zipWithIndex.map { line =>
      val delta = brackets(line._1)
      bracketDepth += delta
      val comma = line._2 match {
        case idx if idx == strippedBlock.size - 1 => false
        case x => brackets(strippedBlock(x + 1)) >= 0
      }
      delta match {
        case 0 => simpleItem(line._1, comma)
        case x if x > 0 => optionsItem(line._1)
        case x if x < 0 => s"))${if (comma) { "," } else { "" }}"
      }
    }
  }
}
