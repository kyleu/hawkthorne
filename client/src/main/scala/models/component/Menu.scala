package models.component

import com.definitelyscala.phaserce.{Game, Group, Image}
import models.font.Font
import models.input.MenuAction
import services.audio.SoundEffectService

final case class Menu(
    override val game: Game, override val name: String, fontKey: String, backgroundKey: String, width: Int, height: Int
) extends BaseComponent {
  val group = new Group(game, name = name)

  private[this] var activeOption = -1
  private[this] var options = IndexedSeq.empty[(String, () => Unit)]
  private[this] var optionImages = Seq.empty[Image]

  SoundEffectService.load("click")
  SoundEffectService.load("confirm")

  val yOffset = 10.0
  val lineHeight = 12.0
  private[this] val font = Font.getFont(fontKey, game)

  val background = new Image(game = game, x = 0, y = 0, key = backgroundKey)
  group.add(background)

  private[this] val arrow = new Image(game, 10, yOffset, "intro.menu.arrow")
  group.add(arrow)

  def setOptions(opts: IndexedSeq[(String, () => Unit)]) = {
    optionImages.foreach { i =>
      group.remove(i)
      i.destroy()
    }
    options = opts
    optionImages = opts.zipWithIndex.map(opt => font.renderToImage(s"menu.$name.${opt._1._1}", opt._1._1, game, 20, yOffset + (opt._2 * lineHeight)))
    optionImages.foreach(i => group.add(i))
    activeOption = 0
  }

  private[this] def previousItem() = activeOption match {
    case _ if activeOption == 0 => // noop
    case _ => setActiveOption(activeOption - 1)
  }

  private[this] def nextItem() = activeOption match {
    case _ if activeOption == options.length - 1 => // noop
    case _ => setActiveOption(activeOption + 1)
  }

  private[this] def setActiveOption(idx: Int) = {
    SoundEffectService.play("click")
    activeOption = idx
    arrow.y = yOffset + (idx * lineHeight)
  }

  private[this] def onSelect() = {
    SoundEffectService.play("confirm")
    options(activeOption)._2()
  }

  def onMenuActions(acts: Seq[MenuAction]) = acts.foreach {
    case MenuAction.Up => previousItem()
    case MenuAction.Down => nextItem()
    case MenuAction.Select => onSelect()
    case _ => // noop
  }

  override def x = group.x
  override def x_=(newX: Double) = group.x = newX
  override def y = group.y
  override def y_=(newY: Double) = group.y = newY

  override def visible = group.visible
  override def visible_=(v: Boolean) = group.visible = v
}
