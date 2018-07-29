package models.intro

import com.definitelyscala.phaserce.{Game, Group, Math, Point}
import models.animation.Animation
import models.component.AnimatedSprite

class IntroScan(game: Game, onComplete: () => Unit) {
  private[this] val rTime = 10.0
  private[this] val cTime = rTime / 7
  private[this] val fTime = cTime / 3
  private[this] val sTime = cTime - fTime

  private[this] val margin = 20
  private[this] val dimensions = (400 + (margin * 2)) -> (250 + (margin * 2))

  private[this] val charOffset = 28 + margin
  private[this] val labelOffset = charOffset + 180

  val group = new Group(game = game, name = s"intro.scan")

  private[this] val background = AnimatedSprite.single(
    game = game, group = group, name = "background", x = margin, y = margin, key = "intro.backgrounds",
    animation = Animation("intro.bg", 0 to 6, rTime / 7, loop = true).newCopy
  )

  private[this] def cs(key: String) = {
    val charFrames = key match {
      case "jeff" => 0 until 19
      case _ => 0 until 19
    }
    val anim = Animation(id = s"intro.${key}scan", frames = charFrames, delay = cTime / 19, loop = false).newCopy
    AnimatedSprite.single(game = game, group = group, name = s"${key}scan", x = charOffset, y = charOffset, key = s"intro.${key}scan", animation = anim)
  }

  private[this] val characters = Seq("jeff", "britta", "abed", "shirley", "annie", "troy", "pierce")
  private[this] val charSprites = characters.map(cs)

  private[this] val description = AnimatedSprite.single(
    game = game, group = group, name = "description", x = charOffset, y = labelOffset, key = "intro.description",
    animation = Animation("intro.description", (0 until 12) :+ 11, cTime / 12, loop = true).newCopy
  )
  private[this] val computer = AnimatedSprite.single(
    game = game, group = group, name = "computer", x = charOffset + 132, y = charOffset + 5 + (172 / 2), key = "intro.computer",
    animation = Animation("intro.computer", 0 until 9, cTime / 9 / 2, loop = true).newCopy
  )
  private[this] val blank = AnimatedSprite.single(
    game = game, group = group, name = "blankscan", x = charOffset + 220, y = charOffset, key = "intro.blankscan",
    animation = Animation("intro.blankscan", 0 until 12, sTime / 12, loop = true).newCopy
  )
  private[this] val scanningBar = AnimatedSprite.single(
    game = game, group = group, name = "scanningbar", x = charOffset + 220, y = labelOffset, key = "intro.scanningbar",
    animation = Animation("intro.scanningbar", 0 until 17, cTime / 17, loop = true).newCopy
  )

  game.world.add(group)

  def update(dt: Double, elapsed: Double) = {
    ((elapsed / rTime) * 7).toInt match {
      case charIdx if charIdx < characters.length =>
        background.update(dt)
        charSprites.zipWithIndex.foreach { c =>
          c._1.sprite.visible = c._2 == charIdx
          if (c._1.sprite.visible) {
            c._1.update(dt)
          }
        }
        description.update(dt)
        computer.update(dt)
        blank.update(dt)
        scanningBar.update(dt)
      case _ => onComplete()
    }
  }

  def resize(width: Int, height: Int) = {
    val wRatio = width.toDouble / dimensions._1
    val hRatio = height.toDouble / dimensions._2
    val scale = Math.min(wRatio, hRatio)
    val x = (width - (dimensions._1 * scale)) / 2
    val y = (height - (dimensions._2 * scale)) / 2
    util.Logging.info(s"width: $width, height: $height, wRatio: $wRatio, hRatio: $hRatio, scale: $scale, x: $x, y: $y")
    group.position.set(Math.max(x, 0), Math.max(y, 0))
    group.scale = new Point(scale, scale)
  }

  def destroy() = {
    game.world.remove(group)
    group.alive = false
    group.visible = false
  }
}
