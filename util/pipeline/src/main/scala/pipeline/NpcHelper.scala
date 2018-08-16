package pipeline

object NpcHelper {
  private[this] def brackets(line: String) = line.count(c => c == '{') -> line.count(c => c == '}')

  private[this] def stripContainer(lines: Seq[String], prefix: String) = lines.head match {
    case x if x.startsWith(prefix) => lines.tail.dropRight(1)
    case x => throw new IllegalStateException(s"Block does not start with prefix [$prefix]")
  }

  def talkItems(block: Seq[String]) = {
    var bracketDepth = 0
    stripContainer(block.map(_.trim.stripPrefix("{").stripSuffix(",").trim.stripSuffix("}")), "talk_items").flatMap { line =>
      val (opens, closes) = brackets(line)
      opens - closes match {
        case 0 => line.indexOf("['text']") match {
          case -1 => throw new IllegalStateException(s"No ['text'] in line [$line]")
          case x =>
            val text = line.substring(x + 9).trim.stripPrefix("'").stripSuffix("'").trim
            Some(s"""${(0 until bracketDepth).map(_ => "  ").mkString}TalkItem(prompt = "$text", responses = Nil)""")
        }
        case x if x < 0 =>
          bracketDepth += x
          Some(s"""${(0 until (bracketDepth - x)).map(_ => "  ").mkString}$line ($bracketDepth)""")
        case x if x > 0 =>
          bracketDepth += x
          Some(s"""${(0 until bracketDepth).map(_ => "  ").mkString}$line ($bracketDepth)""")
      }
    }
  }
}
