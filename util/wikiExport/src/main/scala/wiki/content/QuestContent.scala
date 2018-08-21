package wiki.content

import models.template.quest.QuestTemplate
import wiki.MarkdownFile

object QuestContent {
  def apply(md: MarkdownFile, o: QuestTemplate) = ContentHelper.attributes(md = md, Seq(
    ("Name", o.name),
    ("Source", o.source),
    ("Infinite", o.infinite.toString),
    ("Skip Prompt", o.skipPrompt.toString),
    ("Success Prompt", o.successPrompt.getOrElse("-")),
    ("Prompt Extra", o.promptExtra.mkString(" / ")),
    ("Give Quest Succeed", o.giveQuestSucceed.mkString(" / ")),
    ("Complete Quest Fail", o.completeQuestFail.mkString(" / ")),
    ("Complete Quest Succeed", o.completeQuestSucceed.mkString(" / ")),
    ("Collect", o.promptExtra.mkString(" / ")),
    ("Reward", o.promptExtra.mkString(" / "))
  ): _*)
}
