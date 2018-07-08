package services.state

import com.definitelyscala.phaserce.{Game, Sprite}
import models.animation.Animation

import scala.util.Random

object IntroScanState {
  def load() = {
    new LoadingState(
      next = new IntroScanState(),
      spritesheets = Seq(
        ("intro.backgrounds", "images/intro/backgrounds.png", 400, 250),
        ("intro.names", "images/intro/names.png", 75, 15),
        ("intro.computer", "images/intro/computer.png", 75, 19),
        ("intro.description", "images/intro/description.png", 121, 13),
        ("intro.scanningbar", "images/intro/scanningbar.png", 121, 13),
        ("intro.scanningwords", "images/intro/scanningwords.png", 121, 13),

        ("intro.blankscan", "images/intro/blankscan.png", 121, 172),
        ("intro.invertedsprites", "images/intro/invertedsprites.png", 121, 172),
        ("intro.invertedscan", "images/intro/invertedscan.png", 121, 172),

        ("intro.jeffscan", "images/intro/jeffscan.png", 121, 172),
        ("intro.brittascan", "images/intro/brittascan.png", 121, 172),
        ("intro.abedscan", "images/intro/abedscan.png", 121, 172),
        ("intro.shirleyscan", "images/intro/shirleyscan.png", 121, 172),
        ("intro.anniescan", "images/intro/anniescan.png", 121, 172),
        ("intro.troyscan", "images/intro/troyscan.png", 121, 172),
        ("intro.piercescan", "images/intro/piercescan.png", 121, 172)
      )
    )
  }

  val rtime = 10.0
  val ctime = rtime / 7
  val ftime = ctime / 3
  val stime = ctime - ftime
}

class IntroScanState() extends GameState("introscan") {
  import IntroScanState._

  private[this] var elapsed: Double = 0.0
  private[this] var background: Option[(Sprite, Animation)] = None
  private[this] var chars: Seq[(Sprite, Animation)] = Nil
  private[this] var computerIcon: Option[(Sprite, Animation)] = None
  private[this] var blank: Option[(Sprite, Animation)] = None

  override def create(game: Game) = {
    background = Some(game.add.sprite(0, 0, "intro.backgrounds", 0) -> Animation("intro.bg", (0 to 6).toSeq, rtime / 7, loop = true))
    val offsetX = 10.0
    val offsetY = 10.0
    chars = Seq(
      // TODO Correct animations
      game.add.sprite(offsetX, offsetY, "intro.jeffscan", 0) -> Animation("intro.jeffscan", (0 to 19).toSeq, ctime / 19, loop = true),
      game.add.sprite(offsetX, offsetY, "intro.brittascan", 0) -> Animation("intro.brittascan", (0 to 19).toSeq, ctime / 19, loop = true),
      game.add.sprite(offsetX, offsetY, "intro.abedscan", 0) -> Animation("intro.abedscan", (0 to 19).toSeq, ctime / 19, loop = true),
      game.add.sprite(offsetX, offsetY, "intro.shirleyscan", 0) -> Animation("intro.shirleyscan", (0 to 19).toSeq, ctime / 19, loop = true),
      game.add.sprite(offsetX, offsetY, "intro.anniescan", 0) -> Animation("intro.anniescan", (0 to 19).toSeq, ctime / 19, loop = true),
      game.add.sprite(offsetX, offsetY, "intro.troyscan", 0) -> Animation("intro.troyscan", (0 to 19).toSeq, ctime / 19, loop = true),
      game.add.sprite(offsetX, offsetY, "intro.piercescan", 0) -> Animation("intro.piercescan", (0 to 19).toSeq, ctime / 19, loop = true)
    )

    computerIcon = Some((
      game.add.sprite(offsetX + 121, offsetY + (172 / 2), "intro.computer", 0),
      Animation("intro.computer", (0 to 7).toSeq, ctime / 8, loop = true)
    ))
    blank = Some((
      game.add.sprite(offsetX + 200, offsetY, "intro.blankscan", 0),
      Animation("intro.blankscan", (0 to 12).toSeq, ctime / 12, loop = true)
    ))
  }

  override def update(game: Game) = {
    elapsed += game.time.physicsElapsed
    background.foreach(b => b._1.frame = b._2.nextFrame(b._1.frame.toString.toInt, elapsed))
    val charIdx = (((elapsed % rtime) / rtime) * 7).toInt
    chars.zipWithIndex.foreach { c =>
      c._1._1.visible = c._2 == charIdx
      if (c._1._1.visible) {
        c._1._1.frame = c._1._2.nextFrame(c._1._1.frame.toString.toInt, elapsed)
      }
    }
    computerIcon.foreach(c => c._1.frame = c._2.nextFrame(c._1.frame.toString.toInt, elapsed))
    blank.foreach(c => c._1.frame = c._2.nextFrame(c._1.frame.toString.toInt, elapsed))
  }
}
