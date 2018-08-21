package wiki.content

import models.npc.TalkItem
import models.template.npc.NpcTemplate
import wiki.MarkdownFile

object NpcContent {
  def apply(md: MarkdownFile, o: NpcTemplate) = {
    md.add()
    o.greeting.foreach(g => md.add(s"*$g*"))

    val attrs: Seq[(String, String)] = Seq(
      ("Name", o.name),
      ("Width", o.width.toString),
      ("Height", o.height.toString)
    ) ++ o.noCommands.map(n => ("No Commands", n)) ++ o.noInventory.map(n => ("No Inventory", n))

    ContentHelper.attributes(md = md, attrs: _*)
    ContentHelper.animations(md, o.animations)

    md.add()
    md.add("## Talk Items")

    def recurse(t: TalkItem, depth: Int = 0): Seq[String] = {
      val leadingWs = (0 until depth).map(_ => ": ").mkString
      val ws = (0 until depth).map(_ => "  ").mkString
      Seq(leadingWs + t.prompt) ++ t.responses.map(r => ws + " - " + r) ++ t.children.flatMap(c => recurse(c, depth + 1))
    }

    val talkItems = o.talkItems.flatMap(t => recurse(t))
    ContentHelper.table(md = md, cols = Seq(('l', 120, "Item")), content = talkItems.map(t => Seq(t)))
  }
}
