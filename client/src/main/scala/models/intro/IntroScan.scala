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

  private[this] val background = AnimatedSprite(
    game = game, group = group, name = "background", x = margin, y = margin, key = "intro.backgrounds",
    animations = animationMap(Animation("intro.bg", 0 to 6, rtime / 7, loop = true))
  )

  def am(id: String, frames: IndexedSeq[Int], delay: Double, loop: Boolean = false) = {
    animationMap(Animation(id = id, frames = 0 until 19, delay = ctime / 19, loop = loop))
  }

  private[this] def cs(key: String) = {
    val animMap = am(id = s"intro.${key}scan", frames = 0 until 19, delay = ctime / 19)
    AnimatedSprite(game = game, group = group, name = s"${key}scan", x = charOffset, y = charOffset, key = s"intro.${key}scan", animations = animMap)
  }

  private[this] val chars = Seq(cs("jeff"), cs("britta"), cs("abed"), cs("shirley"), cs("annie"), cs("troy"), cs("pierce"))

  private[this] val description = AnimatedSprite(
    game = game, group = group, name = "description", x = charOffset, y = labelOffset, key = "intro.description",
    animations = am("intro.description", (0 until 12) :+ 11, ctime / 12, loop = true)
  )
  private[this] val computer = AnimatedSprite(
    game = game, group = group, name = "computer", x = charOffset + 132, y = charOffset + 5 + (172 / 2), key = "intro.computer",
    animations = am("intro.computer", 0 until 9, ctime / 9 / 2, loop = true)
  )
  private[this] val blank = AnimatedSprite(
    game = game, group = group, name = "blankscan", x = charOffset + 220, y = charOffset, key = "intro.blankscan",
    animations = am("intro.blankscan", 0 until 12, stime / 12, loop = true)
  )
  private[this] val scanningbar = AnimatedSprite(
    game = game, group = group, name = "scanningbar", x = charOffset + 220, y = labelOffset, key = "intro.scanningbar",
    animations = am("intro.scanningbar", 0 until 17, ctime / 17, loop = true)
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
    scanningbar.update(dt)
  }
}
