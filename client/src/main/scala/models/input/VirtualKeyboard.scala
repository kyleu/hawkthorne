package models.input

import com.definitelyscala.phaserce._
import models.component.SimpleComponent
import models.font.Font
import models.input.VirtualKeyboardKeys._
import util.{IntPoint, NullUtils, PhaserUtils}

class VirtualKeyboard(override val game: Game, override val name: String, initial: IntPoint, onChar: Char => Unit) extends SimpleComponent {
  private[this] val key = "virtual.keyboard"
  private[this] val font = Font.getFont("courier", game)

  private[this] def keyTexture(width: Double) = {
    val w = width * keySize + ((width - 1) * padding)
    val g = new Graphics(game)
    g.beginFill(0x3ebe0f)
    g.drawRoundedRect(0, 0, w, keySize, 4)
    g.endFill()
    g.beginFill(0x1c530e)
    g.drawRoundedRect(1, 1, w - 2, keySize - 2, 4)
    g.endFill()
    g.generateTexture().asInstanceOf[RenderTexture]
  }

  private[this] val keyTextureSizeOne = keyTexture(1)
  private[this] val keyTextureSizeTwo = keyTexture(2)
  private[this] val keyTextureSizeThree = keyTexture(3)
  private[this] val keyTextureSizeSeven = keyTexture(7)

  private[this] val tint = Color.toRGBA(224, 224, 224, 192)

  val group = new Group(game)
  group.name = key
  group.x = initial.x.toDouble
  group.y = initial.y.toDouble

  private[this] var sprites: Seq[(Sprite, Seq[Sprite])] = Nil

  layout.zipWithIndex.foreach { line =>
    var offsetX = 0.0
    line._1.foreach { char =>
      val (display, charSize) = char match {
        case '_' => Some(" ") -> 7.0
        case '|' => Some("ENTER") -> 2.0
        case '0' => Some("0") -> 3.0
        case '-' => None -> 0.5
        case ' ' => None -> 1.0
        case _ => Some(char.toUpper.toString) -> 1.0
      }
      display.foreach { displayStr =>
        val texture = charSize match {
          case 1.0 => keyTextureSizeOne
          case 2.0 => keyTextureSizeTwo
          case 3.0 => keyTextureSizeThree
          case 7.0 => keyTextureSizeSeven
          case x => throw new IllegalStateException(s"Missing texture for width [$x].")
        }

        val bg = new Sprite(game, x = offsetX, y = line._2 * paddedSize, texture)
        bg.inputEnabled = true
        PhaserUtils.addToSignal(bg.events.onInputOver, _ => {
          bg.tint = tint
        })
        PhaserUtils.addToSignal(bg.events.onInputOut, _ => {
          bg.tint = 0xffffffff
        })
        group.add(bg)

        val fontOffsetX = displayStr.length match {
          case 5 => 6
          case _ => 12
        }
        val charSprites = displayStr.zipWithIndex.map { c =>
          font.spriteCopyFor(c._1, x = offsetX + fontOffsetX + (c._2 * 14), y = 10 + (line._2 * paddedSize))
        }
        charSprites.foreach(s => group.add(s))
        sprites = sprites :+ (bg -> charSprites)
      }
      offsetX += (charSize * paddedSize)
    }
  }

  override def comp = group

  override def destroy() = group.destroy()
}
