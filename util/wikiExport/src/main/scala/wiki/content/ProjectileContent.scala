package wiki.content

import models.template.projectile.ProjectileTemplate
import wiki.MarkdownFile

object ProjectileContent {
  def apply(md: MarkdownFile, o: ProjectileTemplate) = {
    ContentHelper.attributes(md = md, Seq(
      ("Name", o.name),
      ("Width", o.width.toString),
      ("Height", o.height.toString)
    ): _*)
    ContentHelper.animations(md, o.animations)
  }
}
