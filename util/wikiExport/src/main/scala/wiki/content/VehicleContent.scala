package wiki.content

import models.template.vehicle.VehicleTemplate
import wiki.MarkdownFile

object VehicleContent {
  def apply(md: MarkdownFile, o: VehicleTemplate) = {
    ContentHelper.attributes(md = md, Seq(
      ("Name", o.name),
      ("Width", o.width.toString),
      ("Height", o.height.toString)
    ): _*)
    ContentHelper.animations(md, o.animations)
  }
}
