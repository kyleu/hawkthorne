package wiki.content

import models.template.inventory.InventoryTemplate
import wiki.MarkdownFile

object InventoryContent {
  def apply(md: MarkdownFile, o: InventoryTemplate) = ContentHelper.attributes(md = md, Seq(
    ("Name", o.name),
    ("Section", o.section),
    ("Info", o.info),
    ("Max Items", o.maxItems.toString)
  ): _*)
}
