package models.component

import com.definitelyscala.phaserce.{Game, Group, Image, Point}
import models.font.Font

final case class Menu(
    override val game: Game,
    override val name: String,
    override val x: Int,
    override val y: Int,
    fontKey: String,
    backgroundKey: String,
    width: Int,
    height: Int
) extends BaseComponent {
  val group = new Group(game, name = name)
  group.position = new Point(x.toDouble, y.toDouble)

  private[this] var activeOption = -1
  private[this] var options = Seq.empty[(String, () => Unit)]
  private[this] var optionImages = Seq.empty[Image]

  private[this] val font = Font.getFont(fontKey, game)

  def setOptions(opts: Seq[(String, () => Unit)]) = {
    optionImages.foreach { i =>
      group.remove(i)
      i.destroy()
    }
    options = opts
    optionImages = opts.zipWithIndex.map(opt => font.renderToImage(s"menu.$name.${opt._1._1}", opt._1._1, game, 20, (opt._2 * 12.0) + 10))
    optionImages.foreach(i => group.add(i))
  }

  val background = new Image(game = game, x = 0, y = 0, key = backgroundKey)
  group.add(background)

  override def update(deltaMs: Double) = {

  }
}
