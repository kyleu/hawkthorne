package wiki.content

import models.data.series.Episode
import models.template.character.CharacterListing
import wiki.{ExportHelper, MarkdownFile}

object EpisodeContent {
  def apply(md: MarkdownFile, o: Episode) = {
    ContentHelper.attributes(md = md, Seq(
      ("Name", o.name),
      ("Season", o.season.toString),
      ("Ep Num", o.episodeNum.toString),
      ("Aired", o.aired.toString),
      ("Summary", o.summary)
    ): _*)

    val costumes = CharacterListing.all.flatMap(c => c.costumes.map(c -> _).filter(c => c._2.episode == o))
    if (costumes.nonEmpty) {
      md.add()
      md.add("## Costumes")
      ContentHelper.table(md = md, cols = Seq(('l', 40, "Character"), ('l', 60, "Key"), ('l', 30, "Name")), content = costumes.map { c =>
        Seq(
          ContentHelper.link(c._1.name, s"Character${c._1.name}"),
          ContentHelper.link(c._2.key, s"Costume${c._1.name}${ExportHelper.toClassName(c._2.key)}"),
          c._2.name
        )
      })
    }
  }
}
