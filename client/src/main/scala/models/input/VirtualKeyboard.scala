package models.input

import com.definitelyscala.phaserce._
import models.component.SimpleComponent
import models.font.Font
import models.input.VirtualKeyboardKeys._

class VirtualKeyboard(override val game: Game, override val name: String, initialX: Int, initialY: Int) extends SimpleComponent {
  private[this] val key = "virtual.keyboard"
  private[this] val font = Font.getFont("courier", game)

  private[this] def keyGraphic(width: Double) = {
    val w = width * keySize + ((width - 1) * padding)
    val g = new Graphics(game)
    g.beginFill(0x3ebe0f)
    g.drawRoundedRect(0, 0, w, keySize, 4)
    g.endFill()
    g.beginFill(0x1c530e)
    g.drawRoundedRect(1, 1, w - 2, keySize - 2, 4)
    g.endFill()
    new Sprite(game, 0, 0, key = g.generateTexture().asInstanceOf[RenderTexture])
  }

  private[this] val keyGraphicOne = keyGraphic(1)
  private[this] val keyGraphicTwo = keyGraphic(2)
  private[this] val keyGraphicThree = keyGraphic(3)
  private[this] val keyGraphicSeven = keyGraphic(7)

  private[this] val bitmapData = new BitmapData(game = game, width = paddedSize * 14, height = paddedSize * 4, key = s"$key.bitmap")

  val group = new Group(game)
  group.name = key

  private[this] val image = new Image(game = game, x = initialX.toDouble, y = initialY.toDouble, key = bitmapData)
  image.name = s"$key.background"
  group.add(image)

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
        val graphics = charSize match {
          case 1.0 => keyGraphicOne
          case 2.0 => keyGraphicTwo
          case 3.0 => keyGraphicThree
          case 7.0 => keyGraphicSeven
          case x => throw new IllegalStateException(s"Missing graphic for width [$x].")
        }
        bitmapData.copy(graphics, tx = offsetX, ty = line._2 * paddedSize)

        val fontOffsetX = displayStr.length match {
          case 5 => 6
          case _ => 12
        }
        displayStr.zipWithIndex.foreach { c =>
          val s = font.spriteCopyFor(c._1, x = offsetX + fontOffsetX + (c._2 * 14), y = 10 + (line._2 * paddedSize))
          bitmapData.copy(s)
          s.destroy()
        }
      }
      offsetX += (charSize * paddedSize)
    }
  }

  override def comp = group
}
