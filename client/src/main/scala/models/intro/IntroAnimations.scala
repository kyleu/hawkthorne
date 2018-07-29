package models.intro

import com.definitelyscala.phaserce.Sprite

object IntroAnimations {
  private[this] val rTime = 10.0
  private[this] val cTime = rTime / 7
  private[this] val fTime = cTime / 3
  private[this] val compTime = cTime / 9
  private[this] val sTime = cTime - fTime
  private[this] val xTime = sTime * 2 / 5

  def backgroundEvents(sprite: Sprite, characters: Seq[String]) = {
    characters.zipWithIndex.map(c => IntroEvent("background", c._1, cTime * c._2, () => sprite.frame = c._2))
  }

  def characterEvents(inverted: Sprite, characters: Seq[(String, Sprite)]) = characters.zipWithIndex.flatMap { c =>
    val ((charKey, charSprite), charIdx) = c
    val offset = charIdx * cTime
    val charFrames = charKey match {
      case "jeff" => 19
      case "britta" => 18
      case "abed" => 17
      case "annie" => 16
      case "troy" => 15
      case _ => 12
    }
    val inc = sTime / charFrames

    val initial = IntroEvent(charKey, "initial", offset + 0.0, () => {
      inverted.visible = false
      charSprite.visible = true
    })
    val spriteEvents = (0 until charFrames).map(f => IntroEvent(charKey, s"char.$charKey", offset + (inc * f), () => charSprite.frame = f))
    val invertStartEvent = IntroEvent(charKey, s"char.invert.0", offset + sTime, () => {
      inverted.visible = true
      charSprite.visible = false
    })
    val invertEvents = invertStartEvent +: Seq(
      IntroEvent(charKey, s"inverted.0", offset + sTime, () => inverted.frame = (charIdx * 2) + 2),
      IntroEvent(charKey, s"inverted.1", offset + sTime + (fTime / 4), () => inverted.frame = (charIdx * 2) + 3),
      IntroEvent(charKey, s"inverted.2", offset + sTime + ((fTime / 4) * 2), () => inverted.frame = (charIdx * 2) + 2),
      IntroEvent(charKey, s"inverted.3", offset + sTime + ((fTime / 4) * 3), () => inverted.frame = (charIdx * 2) + 3)
    )
    val complete = IntroEvent(charKey, "complete", offset + cTime, () => charSprite.visible = false)

    initial +: (spriteEvents ++ invertEvents) :+ complete
  }

  def computerEvents(sprite: Sprite, size: Int) = (0 until size).flatMap { idx =>
    (0 until 9).map(fIdx => IntroEvent(s"computer.$idx", s"scan.$fIdx", (cTime * idx) + (compTime * fIdx), () => sprite.frame = fIdx))
  }

  def descriptionEvents(sprite: Sprite, size: Int) = (0 until size).flatMap { idx =>
    (0 until 12).map(fIdx => IntroEvent(s"description.$idx", s"scan.$fIdx", (cTime * idx) + (sTime / 12 * fIdx), () => sprite.frame = fIdx))
  }

  def nameEvents(sprite: Sprite, size: Int) = (0 until size).flatMap { idx =>
    val seq = (0 until 5).map(fIdx => IntroEvent(s"name.$idx", s"scan.$fIdx", (cTime * idx) + (sTime + fTime / 6 * fIdx), () => sprite.frame = fIdx))
    IntroEvent(s"name.$idx", s"scan.reset", cTime * idx, () => sprite.frame = 0) +: seq :+ IntroEvent(
      t = s"name.$idx", event = s"scan.complete", delay = (cTime * idx) + (sTime + fTime / 6 * 5), trigger = () => sprite.frame = idx + 5
    )
  }

  def progressEvents(sprite: Sprite, size: Int) = (0 until size).flatMap { idx =>
    (0 until 18).map(fIdx => IntroEvent(s"progress.$idx", s"scan.$fIdx", (cTime * idx) + (cTime / 18 * fIdx), () => sprite.frame = fIdx))
  }

  def scanEvents(blank: Sprite, sprites: Sprite, size: Int) = (0 until size).flatMap { idx =>
    IndexedSeq.empty[IntroEvent]
  }

  def wordsEvents(sprite: Sprite, size: Int) = (0 until size).flatMap { idx =>
    Seq(
      IntroEvent(s"words.$idx", "scan", (cTime * idx) + (compTime * 0), () => sprite.frame = 0),
      IntroEvent(s"words.$idx", "scan", (cTime * idx) + (compTime * 1), () => sprite.frame = 1),
      IntroEvent(s"words.$idx", "scan", (cTime * idx) + (compTime * 2), () => sprite.frame = 2),
      IntroEvent(s"words.$idx", "scan", (cTime * idx) + (compTime * 3), () => sprite.frame = 3),
      IntroEvent(s"words.$idx", "scan", (cTime * idx) + (compTime * 4), () => sprite.frame = 0),
      IntroEvent(s"words.$idx", "scan", (cTime * idx) + (compTime * 5), () => sprite.frame = 1),
      IntroEvent(s"words.$idx", "scan", (cTime * idx) + (compTime * 6), () => sprite.frame = 2),
      IntroEvent(s"words.$idx", "scan", (cTime * idx) + (compTime * 7), () => sprite.frame = 3),
      IntroEvent(s"words.$idx", "scan", (cTime * idx) + (compTime * 8), () => sprite.frame = 4)
    )
  }

  def onComplete(f: () => Unit) = Seq(IntroEvent("intro", "complete", rTime, f))
}
