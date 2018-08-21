package wiki.content

import models.template.enemy.EnemyTemplate
import wiki.MarkdownFile

object EnemyContent {
  def apply(md: MarkdownFile, o: EnemyTemplate) = {
    ContentHelper.attributes(md = md, Seq(
      ("Name", o.name),
      ("Width", o.width.toString),
      ("Height", o.height.toString),
      ("Damage", o.damage.toString),
      ("HP", o.hp.toString),
      ("Is Boss", o.isBoss.toString),
      ("Passive Sound", o.passiveSound.getOrElse("-")),
      ("Attack Sounds", o.attackSounds.mkString(" / ")),
      ("Die Sound", o.dieSound.getOrElse("-")),
      ("Sounds", o.sounds.mkString(", "))
    ): _*)
    ContentHelper.animations(md, o.animations)
  }
}
