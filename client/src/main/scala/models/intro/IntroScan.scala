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

  val group = new Group(game = game, name = s"intro.scan")

  private[this] val background = AnimatedSprite.single(
    game = game, group = group, name = "background", x = margin, y = margin, key = "intro.backgrounds",
    animation = Animation("intro.bg", 0 to 6, rtime / 7, loop = true).newCopy
  )

  private[this] def cs(key: String) = {
    val anim = Animation(id = s"intro.${key}scan", frames = 0 until 19, delay = ctime / 19, loop = false).newCopy
    AnimatedSprite.single(game = game, group = group, name = s"${key}scan", x = charOffset, y = charOffset, key = s"intro.${key}scan", animation = anim)
  }

  private[this] val chars = Seq(
    cs("jeff"), cs("britta"), cs("abed"), cs("shirley"), cs("annie"), cs("troy"), cs("pierce")
  )

  private[this] val description = AnimatedSprite.single(
    game = game, group = group, name = "description", x = charOffset, y = labelOffset, key = "intro.description",
    animation = Animation("intro.description", (0 until 12) :+ 11, ctime / 12, loop = true).newCopy
  )
  private[this] val computer = AnimatedSprite.single(
    game = game, group = group, name = "computer", x = charOffset + 132, y = charOffset + 5 + (172 / 2), key = "intro.computer",
    animation = Animation("intro.computer", 0 until 9, ctime / 9 / 2, loop = true).newCopy
  )
  private[this] val blank = AnimatedSprite.single(
    game = game, group = group, name = "blankscan", x = charOffset + 220, y = charOffset, key = "intro.blankscan",
    animation = Animation("intro.blankscan", 0 until 12, stime / 12, loop = true).newCopy
  )
  private[this] val scanningBar = AnimatedSprite.single(
    game = game, group = group, name = "scanningbar", x = charOffset + 220, y = labelOffset, key = "intro.scanningbar",
    animation = Animation("intro.scanningbar", 0 until 17, ctime / 17, loop = true).newCopy
  )

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
    scanningBar.update(dt)
  }
}
