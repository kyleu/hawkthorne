package pipeline

import pipeline.file.ScalaFile
import util.LuaUtils

import scala.collection.immutable
import scala.io.Source

object QuestFiles {
  def process(cfg: PipelineConfig) = {
    val files = (cfg.src / "npcs" / "quests").children.filter(LuaUtils.qualifies).toSeq.map { src =>
      val lines = Source.fromString(src.contentAsString).getLines.map(_.trim).toIndexedSeq

      val key = src.name.stripSuffix(".lua").stripSuffix("quest")
      val name = QuestHelper.questgiverNameFor(key)

      val pkg = Seq("models", "data", "quest")
      val file = ScalaFile(pkg = pkg, key = name + "Quests", root = Some("shared/src/main/scala"))

      file.addImport("models.template.quest", "QuestTemplate")

      file.add(s"object ${name}Quests {", 1)
      val quests = getQuests(lines)
      quests.foreach { q =>
        file.add(s"val ${q.key} = QuestTemplate(", 1)
        file.add(s"""key = "${q.key}",""")
        file.add(s"""name = "${q.name}",""")
        file.add(s"""source = "$name",""")
        file.add(s"""infinite = ${q.infinite},""")
        file.add(s"""skipPrompt = ${q.skipPrompt},""")
        file.add(s"""successPrompt = ${QuestHelper.optionField(q.successPrompt)},""")
        QuestHelper.optionSeqField("promptExtra", q.promptExtra, file)
        QuestHelper.optionSeqField("giveQuestSucceed", q.giveQuestSucceed, file)
        QuestHelper.optionSeqField("completeQuestFail", q.completeQuestFail, file)
        QuestHelper.optionSeqField("completeQuestSucceed", q.completeQuestSucceed, file)
        file.add(s"""collect = ${QuestHelper.collectField(q.collect)},""")
        file.add(s"""reward = ${QuestHelper.rewardField(q.reward)}""")
        file.add(")", -1)
        file.add()
      }
      file.add(s"""val all = Seq(${quests.map(_.key).mkString(", ")})""")
      file.add("}", -1)

      (name, cfg.writeScalaResult(s"quests/${src.name}", file.path -> file.rendered), quests)
    }
    files.flatMap(_._2)
  }

  private[this] def getQuests(lines: immutable.IndexedSeq[String]) = {
    var bracketCount = 0
    var acc = Seq.empty[String]
    var ret = Seq.empty[(String, Seq[String])]
    var currName: Option[String] = None
    lines.foreach { line =>
      val delta = line.count(x => x == '{') - line.count(x => x == '}')
      bracketCount += delta
      acc = acc :+ line
      if (delta > 0) {
        bracketCount match {
          case 2 =>
            currName.foreach(s => throw new IllegalStateException(s"Forgot to clear name [$s]"))
            val q = line.substring(0, line.indexOf(' '))
            currName = Some(q)
          case _ => //noop
        }
      }
      if (delta < 0) {
        bracketCount match {
          case 1 =>
            val curr = currName.getOrElse(throw new IllegalStateException("No current name for completed quest."))
            currName = None
            ret = ret :+ (curr -> acc.tail.dropRight(1))
            acc = Nil
          case _ => // noop
        }
      }
    }

    ret.map(r => QuestHelper.parseQuest(r._1, r._2.toIndexedSeq))
  }
}
