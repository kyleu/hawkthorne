package pipeline

import util.LuaUtils

object QuestHelper {
  case class Quest(key: String, name: String, infinite: Boolean, successPrompt: Option[String])

  private[this] def strip(s: String) = s.trim.stripPrefix("'").stripPrefix("\"").stripSuffix("'").stripSuffix("\"").trim

  def parseQuest(key: String, lines: IndexedSeq[String]) = {
    val name = strip(LuaUtils.lineFor(key, lines, "questName ="))
    val infinite = LuaUtils.lineOpt(lines, "infinite =").exists(s => strip(s).toBoolean)
    val successPrompt = LuaUtils.lineOpt(lines, "successPrompt =").map(strip)
    Quest(key = questKeyFor(key), name = name, infinite = infinite, successPrompt = successPrompt)
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
