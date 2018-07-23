package models.intro

import com.definitelyscala.phaserce.{Game, Group}
import models.animation.Animation
import models.component.AnimatedSprite

class IntroScan(game: Game) {
  val rtime = 10.0
  val ctime = rtime / 7
  val ftime = ctime / 3
  val stime = ctime - ftime

  private[this] val margin = 20
  val dimensions = (400 + (margin * 2)) -> (250 + (margin * 2))
  private[this] val charOffset = 28 + margin
  private[this] val labelOffset = charOffset + 180
  private[this] def animationMap(a: Animation*) = a.map(a => a.id -> a).toMap

  val group = new Group(game = game, name = s"intro.scan")

  private[this] val background = AnimatedSprite(game, group, "background", margin, margin, "intro.backgrounds", animationMap(Animation("intro.bg", 0 to 6, rtime / 7, loop = true)))

  private[this] val chars = Seq(
    // TODO Correct animations
    AnimatedSprite(game, group, "jeffscan", charOffset, charOffset, "intro.jeffscan", animationMap(Animation("intro.jeffscan", 0 until 19, ctime / 19))),
    AnimatedSprite(game, group, "brittascan", charOffset, charOffset, "intro.brittascan", animationMap(Animation("intro.brittascan", 0 until 19, ctime / 19))),
    AnimatedSprite(game, group, "abedscan", charOffset, charOffset, "intro.abedscan", animationMap(Animation("intro.abedscan", 0 until 19, ctime / 19))),
    AnimatedSprite(game, group, "shirleyscan", charOffset, charOffset, "intro.shirleyscan", animationMap(Animation("intro.shirleyscan", 0 until 19, ctime / 19))),
    AnimatedSprite(game, group, "anniescan", charOffset, charOffset, "intro.anniescan", animationMap(Animation("intro.anniescan", 0 until 19, ctime / 19))),
    AnimatedSprite(game, group, "troyscan", charOffset, charOffset, "intro.troyscan", animationMap(Animation("intro.troyscan", 0 until 19, ctime / 19))),
    AnimatedSprite(game, group, "piercescan", charOffset, charOffset, "intro.piercescan", animationMap(Animation("intro.piercescan", 0 until 19, ctime / 19)))
  )

  private[this] val description = AnimatedSprite(game, group, "description", charOffset, labelOffset, "intro.description", animationMap(Animation("intro.description", (0 until 12) :+ 11, ctime / 12, loop = true)))
  private[this] val computer = AnimatedSprite(game, group, "computer", charOffset + 132, charOffset + 5 + (172 / 2), "intro.computer", animationMap(Animation("intro.computer", 0 until 9, ctime / 9 / 2, loop = true)))
  private[this] val blank = AnimatedSprite(game, group, "blankscan", charOffset + 220, charOffset, "intro.blankscan", animationMap(Animation("intro.blankscan", 0 until 12, stime / 12, loop = true)))
  private[this] val scanningbar = AnimatedSprite(game, group, "scanningbar", charOffset + 220, labelOffset, "intro.scanningbar", animationMap(Animation("intro.scanningbar", 0 until 17, ctime / 17, loop = true)))

  game.add.audio("music.opening").play(loop = false)
  game.world.add(group)

  def update(dt: Double, elapsed: Double) = {
    background.update(dt)
    val charIdx = (((elapsed % rtime) / rtime) * 7).toInt
    chars.zipWithIndex.foreach { c =>
      c._1.sprite.visible = c._2 == charIdx
      if (c._1.sprite.visible) {
        c._1.update(dt)
      }
    }
    description.update(dt)
    computer.update(dt)
    blank.update(dt)
    scanningbar.update(dt)
  }
}
