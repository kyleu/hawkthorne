package models.input

import com.definitelyscala.phaserce._
import models.component.SimpleComponent
import models.font.Font
import models.input.VirtualKeyboardKeys._
import util.{IntPoint, PhaserUtils}

class VirtualKeyboard(
    override val game: Game,
    override val name: String,
    initial: IntPoint,
    onChar: Char => Unit,
    onEnter: () => Unit
) extends SimpleComponent {
  private[this] val key = "virtual.keyboard"
  private[this] val font = Font.getFont("courier", game)

  private[this] val textures = new VirtualKeyboardTextures(game)

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
        val texture = textures.forSize(charSize.toInt)

        val bg = new Sprite(game, x = offsetX, y = line._2 * paddedSize, texture)
        bg.inputEnabled = true
        PhaserUtils.addToSignal(bg.events.onInputOver, _ => {
          bg.tint = tint
        })
        PhaserUtils.addToSignal(bg.events.onInputOut, _ => {
          bg.tint = 0xffffffff
        })
        PhaserUtils.addToSignal(bg.events.onInputDown, _ => {
          displayStr match {
            case "ENTER" => onEnter()
            case " " => onChar(' ')
            case x if x.length == 1 => onChar(x.head.toLower)
            case _ => throw new IllegalStateException(s"Unhandled key [$displayStr]")
          }
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
