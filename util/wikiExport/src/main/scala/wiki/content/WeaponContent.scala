package wiki.content

import models.template.weapon.WeaponTemplate
import wiki.MarkdownFile

object WeaponContent {
  def apply(md: MarkdownFile, o: WeaponTemplate) = {

    val attrs = Seq(
      "Name" -> o.name,
      "Width" -> o.width.toString,
      "Height" -> o.height.toString
    ) ++
      o.hitAudioClip.map(n => ("Hit Audio Clip", n)) ++
      o.swingAudioClip.map(n => ("Swing Audio Clip", n)) ++
      o.unuseAudioClip.map(n => ("Unuse Audio Clip", n))

    ContentHelper.attributes(md = md, attrs: _*)
    ContentHelper.animations(md, o.animations)
  }
}
