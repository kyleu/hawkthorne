package models.intro

import com.definitelyscala.phaserce.Sprite

object IntroAnimations {
  private[this] val rTime = 10.0
  private[this] val cTime = rTime / 7
  private[this] val fTime = cTime / 3
  private[this] val compTime = cTime / 9
  private[this] val sTime = cTime - fTime
  private[this] val charFrames = Map("jeff" -> 19, "britta" -> 18, "abed" -> 17, "annie" -> 16, "troy" -> 15)

  def backgroundEvents(sprite: Sprite, characters: Seq[String]) = {
    characters.zipWithIndex.map(c => IntroEvent("background", c._1, cTime * c._2, () => sprite.frame = c._2))
  }

  def characterEvents(inverted: Sprite, characters: Seq[(String, Sprite)]) = characters.zipWithIndex.flatMap { c =>
    val ((charKey, charSprite), charIdx) = c
    val offset = charIdx * cTime
    val charFrameCount = charFrames.getOrElse(charKey, 12)
    val inc = sTime / charFrameCount

    val initial = IntroEvent(charKey, "initial", offset + 0.0, () => {
      inverted.visible = false
      charSprite.visible = true
    })
    val spriteEvents = (0 until charFrameCount).map(f => IntroEvent(charKey, s"char.$charKey", offset + (inc * f), () => charSprite.frame = f))
    val invertEvents = IntroEvent(charKey, s"char.invert.0", offset + sTime, () => {
      inverted.visible = true
      charSprite.visible = false
    }) +: Seq(2, 3, 2, 3).zipWithIndex.map {
      case (frame, idx) => IntroEvent(charKey, s"inverted.$idx", offset + sTime + ((fTime / 4) * idx), () => inverted.frame = (charIdx * 2) + frame)
    }
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
    Seq(IntroEvent(s"scan.$idx", s"blank.start", cTime * idx, () => blank.visible = true)) ++
      (0 until 11).map(sIdx => IntroEvent(s"scan.$idx", s"blank.$sIdx", (cTime * idx) + ((sTime / 12) * sIdx), () => blank.frame = sIdx)) ++
      Seq(IntroEvent(s"scan.$idx", s"blank.complete", cTime * idx + sTime, () => blank.visible = false)) ++
      Seq(IntroEvent(s"scan.$idx", s"sprites.start", cTime * idx + sTime, () => sprites.visible = true)) ++
      (0 until 4).map(si => IntroEvent(s"scan.$idx", s"sprites.$si", (cTime * idx) + sTime + ((fTime / 4) * si), () => sprites.frame = (idx * 4) + si)) ++
      Seq(IntroEvent(s"scan.$idx", s"sprites.complete", cTime * idx + cTime, () => sprites.visible = false))
  }

  def wordsEvents(sprite: Sprite, size: Int) = (0 until size).flatMap(idx => Seq(0, 1, 2, 3, 0, 1, 2, 3, 4).zipWithIndex.map {
    case (frame, fIdx) => IntroEvent(s"words.$idx", "scan", (cTime * idx) + (compTime * fIdx), () => sprite.frame = frame)
  })

  def onComplete(f: () => Unit) = Seq(IntroEvent("intro", "complete", rTime, f))
}
