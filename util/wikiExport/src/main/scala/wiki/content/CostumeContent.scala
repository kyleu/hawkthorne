package wiki.content

import models.player.Costume
import models.template.character.CharacterTemplate
import wiki.MarkdownFile

object CostumeContent {
  def apply(md: MarkdownFile, o: (CharacterTemplate, Costume)) = ContentHelper.attributes(md = md, Seq(
    ("Name", o._2.name),
    ("Character", ContentHelper.link(o._1.name, s"Character${o._1.name}")),
    ("Episode", ContentHelper.link(o._2.episode.value, s"Episode${o._2.episode.value}"))
  ): _*)
}
