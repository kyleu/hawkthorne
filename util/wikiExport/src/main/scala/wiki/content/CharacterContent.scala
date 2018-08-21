package wiki.content

import models.template.character.CharacterTemplate
import wiki.MarkdownFile

object CharacterContent {
  private[this] val costumeHeaders = Seq(('l', 60, "Key"), ('l', 40, "Name"), ('l', 40, "Episode"))

  def apply(md: MarkdownFile, o: CharacterTemplate) = {
    ContentHelper.attributes(md = md, Seq(
      ("Name", o.name),
      ("Given Name", o.givenName),
      ("BoundingBox", o.boundingBox.toString),
      ("Offset", o.offset.toString)
    ): _*)

    md.add()
    md.add("## Costumes")
    ContentHelper.table(md = md, cols = costumeHeaders, content = o.costumes.map { c =>
      Seq(
        ContentHelper.link(c.key, s"Costume${o.name}${c.key.head.toUpper}${c.key.tail}"),
        c.name,
        ContentHelper.link(c.episode.value, s"Episode${c.episode.value}")
      )
    })
  }
}
