package pipeline

import util.LuaUtils

object QuestHelper {
  case class Quest(
      key: String,
      name: String,
      infinite: Boolean,
      skipPrompt: Boolean,
      successPrompt: Option[String],
      promptExtra: Option[Seq[String]],
      giveQuestSucceed: Option[Seq[String]],
      completeQuestFail: Option[Seq[String]],
      completeQuestSucceed: Option[Seq[String]],
      collect: Map[String, String],
      reward: Map[String, String]
  )

  def parseQuest(key: String, lines: IndexedSeq[String]) = {
    val name = strip(LuaUtils.lineFor(key, lines, "questName ="))
    val infinite = LuaUtils.lineOpt(lines, "infinite =").exists(s => strip(s).toBoolean)
    val skipPrompt = LuaUtils.lineOpt(lines, "skipPrompt =").exists(s => strip(s).toBoolean)
    val promptExtra = getBracketSection("promptExtra =", lines)
    val giveQuestSucceed = getBracketSection("giveQuestSucceed =", lines)
    val successPrompt = LuaUtils.lineOpt(lines, "successPrompt =").map(strip)
    val completeQuestFail = getBracketSection("completeQuestFail =", lines)
    val completeQuestSucceed = getBracketSection("completeQuestSucceed =", lines)
    val reward = parseMap("reward =", lines)
    val collect = parseMap("collect =", lines)
    Quest(
      key = questKeyFor(key),
      name = name,
      infinite = infinite,
      skipPrompt = skipPrompt,
      successPrompt = successPrompt,
      promptExtra = promptExtra,
      giveQuestSucceed = giveQuestSucceed,
      completeQuestFail = completeQuestFail,
      completeQuestSucceed = completeQuestSucceed,
      collect = collect,
      reward = reward
    )
  }

  def strip(s: String) = s.trim.stripPrefix("'").stripPrefix("\"").stripSuffix(",").stripSuffix("'").stripSuffix("\"").trim

  private[this] def getBracketSection(prefix: String, lines: IndexedSeq[String]) = {
    lines.indexWhere(_.startsWith(prefix)) match {
      case -1 => None
      case startIdx =>
        var acc = Seq.empty[String]
        var depth = 0
        val candidates = lines.drop(startIdx)
        val ret = candidates.takeWhile { l =>
          val delta = l.count(_ == '{') - l.count(_ == '}')
          depth += delta
          if (delta == 0) {
            acc = acc :+ l.stripPrefix(prefix)
          }
          depth > 0
        }
        Some(acc.toIndexedSeq.map(strip))
    }
  }

  private[this] def parseMap(prefix: String, lines: IndexedSeq[String]) = {
    val ret = LuaUtils.lineOpt(lines, prefix).map(_.stripPrefix(prefix)).map(strip) match {
      case None => Map.empty[String, String]
      case Some(line) => line.stripPrefix("{").stripSuffix("}").split(',').toIndexedSeq.map(strip).map { kv =>
        kv.split('=').toList match {
          case k :: v :: Nil => k.trim -> strip(v.trim)
          case x => throw new IllegalStateException(s"Invalid [$prefix] line [$line] with kv [$kv}]")
        }
      }
    }
    ret.toMap
  }

  private[this] def questKeyFor(key: String) = key match {
    case "alienobject" => "alienObject"
    case "aliencamp" => "alienCamp"
    case "peanutcostume" => "peanutCostume"
    case "officekey" => "officeKey"
    case "poolreturn" => "poolReturn"
    case "dianemail" => "dianeEmail"
    case "dianereturn" => "dianeReturn"
    case _ => ExportHelper.toIdentifier(key)
  }
}
